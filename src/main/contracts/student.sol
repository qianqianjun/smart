pragma solidity ^0.4.17;
contract Student{
    string public sname;
    string public schoolInfo;
    address public account;
    certificate[] public books;
    struct certificate{
        string cname;
        string Type;
        string content;
        string organization;
        string bookurl;
        string abstruct;
    }
    function Student(string _name,string _schoolInfo,address _account) public{
        sname=_name;
        schoolInfo=_schoolInfo;
        account=_account;
    }
    function getSname() public view returns(string){return sname;}
    function setSname(string _sname) public{require(msg.sender==account);sname=_sname;}
    function getSchoolInfo() public view returns(string){return schoolInfo;}
    function setSchoolInfo(string _schoolInfo) public{schoolInfo=_schoolInfo;}
    function getBookCount() public view returns(uint){return books.length;}
    function getBookByIndex(uint index) public view returns(string,string,string,string,string,string){
        require(index<books.length);
        certificate memory book=books[index];
        return (book.cname,book.Type,book.content,book.organization,book.bookurl,book.abstruct);
    }

    function receiveCertificate(string _cname,string _Type,string _content,string _organization,string _bookurl,string _abstruct) public{
        certificate memory cerf=certificate(_cname,_Type,_content,_organization,_bookurl,_abstruct);
        books.push(cerf);
    }
}