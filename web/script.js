function validateRegister()
{   var check=1;
    if(document.register.fname.value == "")
	{alert("Empty Last Name"); check=0;
	}
	if(document.register.lname.value == "")
	{alert("Empty Last Name"); check=0;
	}
	if(document.register.username.value == "")
	{alert("Empty UserName"); check=0;
	}
	if(document.register.password.value == "")
	{alert("Empty Password"); check=0;
	}
	if(document.register.configpassword.value == "")
	{alert("Empty Confirm Password"); check=0;
	}
	else if ( document.register.password.value != "" && document.register.password.value != document.register.configpassword.value)
	{alert("Passwords do not match"); check=0;
	}
    if(check)
    {alert("REGISTER SUCCESSFULL"); 
	}
	//if(document.SignUP.email.value == "")
	//{alert("Empty Email");  
	//}
}
