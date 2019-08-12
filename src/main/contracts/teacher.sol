pragma solidity ^0.4.17;
import "./resource.sol";
import "./student.sol";
contract Teacher{
    string public tname;
    bool public status;
    address [] public resources;
    mapping(bytes32 => Resource ) resourceMapper;
    mapping(bytes32 => Resource) Null;
    address public owner;
    function Teacher(string _name,address _owner) public{tname=_name;owner=_owner;}
    function getResourcesCount() public view returns(uint){return resources.length;}
    function setTname(string _name) public{require(owner==msg.sender);tname=_name;}
    function getTname() public view returns(string){return tname;}
    function setStatus(bool _status) public{status=_status;}
    function getStatus() public view returns(bool){return status;}

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