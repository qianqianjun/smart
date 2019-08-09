pragma solidity ^0.4.17;
contract Resource{
    // the name of the resource
    string rname;
    // the owner of the resource.
    address owner;
    // the http address of the resource.
    string url;
    // the price of the resource.
    uint32 price;
    // the record of the resource.
    struct Message{
        uint256 time;
        uint8 Type;
        address Buyer;
        address value;
        address OldOwner;
        address NewOwner;
    }
    Message[] messages;
    // the buyer of the Resource
    address[] buyers;
    // the mapper of the buyer;
    mapping(address=>uint8) buyerMapper;
    function Resource(string _rname,uint32 _price,address _owner,string _url) public{
        owner=_owner;
        rname=_rname;
        price=_price;
        url=_url;
    }
    function getBuyerLength() public view returns(uint) {
        return buyers.length;
    }
    function buy() public payable{
        require(msg.value==price);
        buyers.push(msg.sender);
        buyerMapper[msg.sender]=1;
        Message memory mess=Message(now,1,msg.sender,price,owner,owner);
        messages.push(mess);
        owner.transfer(price);
    }

    function getBuyerByAddress(address add) public view returns(uint8){
        return buyerMapper[add];
    }

    function setRname(string new_rname) public{
        require(msg.sender==owner);
        rname=new_rname;
    }
    function getRname() public view returns(string){
        return rname;
    }
    function setUrl(string _url) public{
        require(msg.sender==owner);
        url=_url;
    }
    function getUrl() public view returns(string){
        return url;
    }
    function setOwner(address new_owner) public{
        owner=new_owner;
    }
    function getOwner() public view returns(address){
        return owner;
    }
    function getPrice() public view returns(uint32){
        return price;
    }
    function setPrice(uint32 new_price) public{
        price=new_price;
    }
    function getIndexKey() public view returns(bytes32){
        return sha256(rname);
    }
}

contract Teacher{
    // the name of the teacher.
    string public tname;
    // the status of the teacher.
    bool public status;
    // the resource which the teaccher publish.
    address [] public resources;
    mapping(bytes32 => Resource ) resourceMapper;
    mapping(bytes32 => Resource) Null;
    // the id of the teacher.
    address public owner;
    // constructor
    function Teacher(string _name,address _owner) public{
        tname=_name;
        owner=_owner;
    }
    function getResourcesCount() public view returns(uint){
        return resources.length;
    }
    function setTname(string _name) public{
        require(owner==msg.sender);
        tname=_name;
    }

    function getTname() public view returns(string){
        return tname;
    }

    function setStatus(bool _status) public{
        status=_status;
    }
    function getStatus() public view returns(bool){
        return status;
    }

    function addResource(string res_name,uint32 price,string url) public{
        require(owner==msg.sender);
        Resource res=new Resource(res_name,price,owner,url);
        bytes32 index=sha256(res_name);
        resourceMapper[index]=res;
        resources.push(res);
    }
    function getResourceByName(string _name) public view returns(Resource){
        bytes32 index=sha256(_name);
        return resourceMapper[index];
    }

    function deleteResourceByName(string _name) public{
        require(msg.sender==owner);
        bytes32 index=sha256(_name);
        delete(resourceMapper[index]);
    }

    function getResourceByIndex(uint i) public view returns(Resource,bool){
        require(i<resources.length);
        Resource res=Resource(resources[i]);
        bytes32 index=res.getIndexKey();
        if(resourceMapper[index]==Null[index]){
            return (res,false);
        }else{
            return (res,true);
        }
    }

    function receiveResource(string res_name,address res_address) public{
        bytes32 index=sha256(res_name);
        resourceMapper[index]=Resource(res_address);
        resources.push(Resource(res_address));
    }

    function transformResource(address other_teacher,string res_name,address res_address) public {
        Teacher other=Teacher(other_teacher);
        other.receiveResource(res_name,res_address);
        bytes32 index=sha256(res_name);
        delete(resourceMapper[index]);
    }
}
contract School{
    // the name of the university.
    string public fullName;
    // the address of the principal.
    address public principal;
    // the manager of the educational
    EduDepartment public  edudepartment;
    // teacher set of the school.
    Teacher[] public teachers;
    mapping(address=>Teacher) teacherMapper;
    // the constructor of the contract.
    function School(string _name,address _principal,EduDepartment father) public{
        fullName=_name;
        principal=_principal;
        edudepartment=father;
    }

    // change the principal of the school.
    function changePrinciple(address new_principal) public{
        require(msg.sender==principal || msg.sender==edudepartment.getMinister());
        principal=new_principal;
    }

    function getFullName() public view returns(string){
        return fullName;
    }

    function setFullName(string new_name) public{
        require(msg.sender==principal);
        fullName=new_name;
    }

    function getPrincipal() public view returns(address){
        return principal;
    }

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

}
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