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