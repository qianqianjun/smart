pragma solidity ^0.4.17;
import "./school.sol";
contract EduDepartment{
    // the minister of the educational department.
    address public minister;
    // the list of all universitys.
    address[] public Schools;
    // map of the university name and address
    mapping(bytes32=>School) public mapper;
    // constructor
    function EduDepartment() public{
        minister=msg.sender;
    }
    //to add a school to the list.
    function addSchool(string _name,address principal) public {
        School new_school=new School(_name,principal,this);
        Schools.push(new_school);
        bytes32 index=sha256(_name);
        mapper[index]=new_school;
    }

    function getMinister() public view returns(address){
        return minister;
    }
    function setMinister(address new_minister) public{
        require(msg.sender==minister);
        minister=new_minister;
    }

    function getSchoolByName(string full_name) public view returns(School){
        bytes32 code=sha256(full_name);
        return mapper[code];
    }
}


