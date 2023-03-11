package com.db2.project2.service;

import com.db2.project2.entity.nested.Department;
import com.db2.project2.entity.nested.Employee;
import com.db2.project2.entity.nested.Project;
import com.db2.project2.entity.normalized.DepartmentNormal;
import com.db2.project2.entity.normalized.EmployeeNormal;
import com.db2.project2.entity.normalized.ProjectNormal;
import com.db2.project2.entity.normalized.WorksOnNormal;
import com.db2.project2.repository.*;
import com.db2.project2.util.CommonUtility;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

@Service
public class DataService {

    final static Logger logger = LoggerFactory.getLogger(DataService.class);

    @Autowired
    private EmployeeNormalRepository employeeNormalRepository;

    @Autowired
    private DepartmentNormalRepository departmentNormalRepository;

    @Autowired
    private ProjectNormalRepository projectNormalRepository;

    @Autowired
    private WorksOnNormalRepository worksOnNormalRepository;

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    public void saveAllNormalizedData(List<EmployeeNormal> employeeNormal, List<DepartmentNormal> departmentNormals, List<ProjectNormal> projectNormals, List<WorksOnNormal> worksOnNormals) {
        employeeNormalRepository.saveAll(employeeNormal);
        departmentNormalRepository.saveAll(departmentNormals);
        projectNormalRepository.saveAll(projectNormals);
        worksOnNormalRepository.saveAll(worksOnNormals);

        logger.info("Data successfully saved in normalized format in MongoDB");
    }

    public void createNestedProjectDocuments() {
        List<EmployeeNormal> employeeNormal = employeeNormalRepository.findAll();
        List<DepartmentNormal> departmentNormals = departmentNormalRepository.findAll();
        List<ProjectNormal> projectNormals = projectNormalRepository.findAll();
        List<WorksOnNormal> worksOnNormals = worksOnNormalRepository.findAll();

        Map<Integer, String> dNo_dName = departmentNormals.stream().collect(Collectors.toMap(DepartmentNormal::getdNumber, DepartmentNormal::getdName));
        Map<String, EmployeeNormal> ssn_employeeNormals = employeeNormal.stream().collect(Collectors.toMap(EmployeeNormal::getSsn, Function.identity()));
        Map<Integer, List<WorksOnNormal>> pno_worksOnNormals = worksOnNormals.stream().collect(groupingBy(WorksOnNormal::getpNo));

        List<Project> projectList = new ArrayList<>();
        // Loop into each ProjectNormals
        for (ProjectNormal projectNormal : projectNormals) {

            // Create Project Object
            Project project = new Project();

            //meta data available in projectNormal
            project.setpName(projectNormal.getpName());
            project.setpNumber(projectNormal.getpNumber());
            project.setdNum(projectNormal.getdNum());
            project.setdName(dNo_dName.get(projectNormal.getdNum()));


            // Get all employee's SSN working on current project - Join Project & WorksOn by Project Number
            List<WorksOnNormal> employeesSSN = worksOnNormalRepository.findBypNo(projectNormal.getpNumber());
            //List<WorksOnNormal> employeesSSN = pno_worksOnNormals.get(projectNormal.getpNumber());

            if (employeesSSN != null && employeesSSN.size() > 0) {
                // Loop for each employee
                for (WorksOnNormal worker : employeesSSN) {
                    EmployeeNormal emp = employeeNormalRepository.findByssn(worker.geteSsn());
                    //EmployeeNormal emp = ssn_employeeNormals.get(worker.geteSsn());

                    project.getEmployees().add(new Employee(emp.getfName(), emp.getMinit(), emp.getlName(), emp.getSsn(), emp.getbDate(), emp.getAddress(), emp.getSex(), emp.getSalary(), emp.getdNo(), worker.getHours()));
                }
            }
            projectList.add(project);
        }

        //logger.info("Parsed {}", CommonUtility.displayJSON(projectList));
        projectRepository.saveAll(projectList);

    }

    public void createNestedEmployeeDocuments() {
        List<EmployeeNormal> employeeNormal = employeeNormalRepository.findAll();
        List<DepartmentNormal> departmentNormals = departmentNormalRepository.findAll();
        List<ProjectNormal> projectNormals = projectNormalRepository.findAll();
        List<WorksOnNormal> worksOnNormals = worksOnNormalRepository.findAll();

        Map<Integer, String> dNo_dName = departmentNormals.stream().collect(Collectors.toMap(DepartmentNormal::getdNumber, DepartmentNormal::getdName));
        Map<Integer, ProjectNormal> pno_projectNormal = projectNormals.stream().collect(Collectors.toMap(ProjectNormal::getpNumber, Function.identity()));
        Map<String, List<WorksOnNormal>> ssn_worksOnNormals = worksOnNormals.stream().collect(groupingBy(WorksOnNormal::geteSsn));

        List<Employee> employeeList = new ArrayList<>();

        for (EmployeeNormal emp : employeeNormal) {
            Employee employee = new Employee();
            employee.metaEmployee(emp);

            List<WorksOnNormal> empProjects = ssn_worksOnNormals.get(emp.getSsn());

            if (empProjects != null && empProjects.size() > 0) {
                for (WorksOnNormal workOn : empProjects) {
                    ProjectNormal projectNormal = pno_projectNormal.get(workOn.getpNo());
                    String dName = dNo_dName.get(projectNormal.getdNum());
                    employee.getProjects().add(new Project(projectNormal.getpName(), projectNormal.getpNumber(), dName, projectNormal.getdNum(), workOn.getHours()));
                }
            }
            employeeList.add(employee);
        }
        //logger.info("Parsed {}", CommonUtility.displayJSON(employeeList));
        employeeRepository.saveAll(employeeList);
    }

    public void createNestedDepartmentDocuments() {
        List<EmployeeNormal> employeeNormal = employeeNormalRepository.findAll();
        List<DepartmentNormal> departmentNormals = departmentNormalRepository.findAll();
        List<ProjectNormal> projectNormals = projectNormalRepository.findAll();
        List<WorksOnNormal> worksOnNormals = worksOnNormalRepository.findAll();

        Map<String, EmployeeNormal> ssn_employeeNormals = employeeNormal.stream().collect(Collectors.toMap(EmployeeNormal::getSsn, Function.identity()));
        Map<Integer, List<EmployeeNormal>> dNo_employeeNormals = employeeNormal.stream().collect(groupingBy(EmployeeNormal::getdNo));

        List<Department> departmentList = new ArrayList<>();

        for (DepartmentNormal dept : departmentNormals) {
            EmployeeNormal deptMgr = ssn_employeeNormals.get(dept.getMgr_ssn());
            Department department = new Department(dept.getdName(), deptMgr.getfName(), deptMgr.getlName(), dept.getMgr_start_date());

            List<EmployeeNormal> employeesInDept = employeeNormalRepository.findBydNo(dept.getdNumber());
            //List<EmployeeNormal> employeesInDept = dNo_employeeNormals.get(dept.getdNumber());

            if (employeesInDept != null && employeesInDept.size() > 0) {
                for (EmployeeNormal emp : employeesInDept) {
                    department.getEmployees().add(new Employee(emp.getfName(), emp.getlName(), emp.getSsn(), emp.getSalary(), emp.getdNo()));
                }
            }
            departmentList.add(department);
        }
        //logger.info("Parsed {}", CommonUtility.displayJSON(departmentList));
        departmentRepository.saveAll(departmentList);
    }

    public void createDepartmentXML() throws JsonProcessingException {

        List<Department> departmentList = departmentRepository.findAll();

        XmlMapper xmlMapper = new XmlMapper();

        try {
            xmlMapper.writer().withRootName("departments").writeValue(new File("Departments.xml"), departmentList);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void testQueries() {
        logger.info("\n\n***** PROJECT COLLECTION QUERIES *****");
        logger.info("Fetching all projects between Project No 1 and 30");
        List<Project> projectList = projectRepository.findBypNumberBetween(1, 30);
        List<String> projectNames = projectList.stream().map(Project::getpName).collect(Collectors.toList());
        logger.info("Project Names with project no between 1 and 30 : {}\n", projectNames);

        logger.info("Fetching all projects with department name = Research or Software");
        List<String> dNameList = new ArrayList<>(List.of("Research", "Software"));
        List<Project> projectsByDeptName = projectRepository.findBydNameIn(dNameList);
        List<String> projectNames2 = projectsByDeptName.stream().map(Project::getpName).collect(Collectors.toList());
        logger.info("Projects with department name = Research or Software: {}\n", projectNames2);

        logger.info("Fetching count of projects with department name = Software");
        Long countByDeptName1 = projectRepository.countBydName("Software");
        logger.info("Count of projects with department name = Software: {}\n", countByDeptName1);

        logger.info("\n\n***** EMPLOYEE COLLECTION QUERIES *****");

        logger.info("Fetching count of employees whose sex = M");
        Long empCount = employeeRepository.countBysex("M");
        logger.info("Count of employees with sex = M: {}\n", empCount);

        logger.info("Fetching employees whose salary >= 90000 And DNO = 7");
        List<Employee> employees = employeeRepository.findBydNoAndSalaryIsGreaterThanEqual(7, 90000);
        logger.info("Employees whose salary >= 90000 And DNO = 7: {}", employees.stream().map(Employee::getfName).collect(Collectors.toList()));

        logger.info("\n\n***** DEPARTMENT COLLECTION QUERIES *****");

        logger.info("Fetching count of employees working in DNAME = Software");
        Department department = departmentRepository.findBydName("Software");
        logger.info("Count of employees working in DNAME = Software: {}\n", department.getEmployees().size());
    }
}
