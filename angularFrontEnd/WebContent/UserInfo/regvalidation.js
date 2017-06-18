function validate()
{
   var uname=document.getElementById("uname").value;
   var exp=new RegExp("^[a-zA-Z]");
   alert(exp.test(uname));
   if(!exp.test(uname))
	   {
	      return false;
	   }
}


