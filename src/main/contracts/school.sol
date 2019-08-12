pragma solidity ^0.4.17;
import "./edu.sol";
import "./teacher.sol";
import "./student.sol";
contract School{
    string public fullName;
    address public principal;
    EduDepartment public  edudepartment;
    Teacher[] public teachers;
    Student[] public students;
    mapping(address=>Student) studentMapper;
    mapping(address=>Teacher) teacherMapper;
    function School(string _name,address _principal,EduDepartment father) public{
        fullName=_name;
        principal=_principal;
        edudepartment=father;
    }
    function changePrinciple(address new_principal) public{require(msg.sender==principal || msg.sender==edudepartment.getMinister());principal=new_principal;}

    function getFullName() public view returns(string){return fullName;}

    function setFullName(string new_name) public{require(msg.sender==principal);fullName=new_name;}

    function getPrincipal() public view returns(address){return principal;}

    function addTeacher(string _name,address taddress) public{
        require(msg.sender==principal);
        Teacher teacher=new Teacher(_name,taddress);
        teachers.push(teacher);
        teacherMapper[taddress]=teacher;
    }
    function getTeacherByTAddress(address taddress) public view returns(Teacher) {
        Teacher teacher=teacherMapper[taddress];
        return teacher;
    }
    function addStudent(address _student,string sname ,string schoolInfo) public{
        Student student=new Student(sname,schoolInfo,_student);
        students.push(student);
        studentMapper[_student]=student;
    }
    function getStudentByAddress(address add) public view returns(address){
        return studentMapper[add];
    }
    function addCertificate(address _student,string _cname,string _Type,string _content,string _organization,string _bookurl,string _abstruct) public{
        Student student=Student(_student);
        student.receiveCertificate(_cname,_Type,_content,_organization,_bookurl,_abstruct);
    }
}