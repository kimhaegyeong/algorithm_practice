/**
 * 		회원관리
 */

var msg_iderror = "아이디를 입력하세요";
var msg_passwderror = "비밀번호를 입력하세요";
var msg_repasswderror = "비밀번호가 다릅니다.\n다시 확인하세요"; 
var msg_nameerror = "이름을 입력하세요";
var msg_juminerror = "주민등록번호를 입력하세요";
var msg_juminlength = "주민등록번호의 길이가 유효하지 않습니다";
var msg_telerror = "전화번호의 길이가 유효하지 않습니다";
var msg_emailerror = "이메일이 유효하지 않습니다";
var msg_confirmerror = "아이디 중복 확인을 해주세요";
var msg_ziperror = "우편번호를 입력하세요";
var msg_adderror = "상세주소를 입력하세요";
var msg_autherror = "인증번호를 입력하세요";
var msg_wrong_num = "인증번호가 틀렸습니다";
var msg_auth = "인증이 완료 되었습니다";
var msg_auth_email =  "이메일 인증을 해주세요";

var inputerror = "회원가입에 실패했습니다\n잠시 후 다시 시도하세요";
var loginiderror = "입력하신 아이디가 없습니다\n다시 확인 하세요";
var loginpasswderror = "입력하신 비밀번호가 다릅니다\n다시 확인하세요";
var deleteerror = "회원탈퇴에 실패했습니다\n잠시 후 다시 시도하세요";
var modifyerror = "회원 정보 수정에 실패했습니다\n잠시 후 다시 시도하세요";

function modifyEmail() {
	modifyform.auth_email.value = "0";
}

function useAuthEmail() {
	if (document.getElementById("auth_email").value == "0") {
		alert("인증되지 않았습니다");
		return false;
	}
	
	var form = null;
	if (typeof opener.document.inputform != "undefined") {
		form = opener.document.inputform;
	} else if (typeof opener.document.modifyform != "undefined") {
		form = opener.document.modifyform;
	}
	
	if (!document.getElementsByName("input_num")[0].value) {
		alert(msg_autherror);
		return false;
	} else {
		form.auth_email.value = "1";
		self.close();
	}
}

function checkAuthNum(auth_num) {	
	if (auth_num != document.getElementsByName("input_num")[0].value) {
		alert(msg_wrong_num);
		console.log(auth_num);
	} else {
		document.getElementById("auth_email").value = "1";
		alert(msg_auth);
	}
}

// 이메일 인증
function authEmail() {
	var form = null;	
	if (typeof inputform != "undefined") {
		form = inputform;
	} else if (typeof modifyform != "undefined") {
		form = modifyform;
	}
		
	if( ! form.email1.value ||
			! form.email2.value ) {
		alert( msg_emailerror );
		form.email1.focus();
		return false;
	}
	if( ( form.email2.value == '0' 
				&& form.email1.value.indexOf( '@' ) == -1 )
			|| ( form.email2.value != '0' 
				&& form.email1.value.indexOf( '@' ) != -1 ) ) {
		alert( msg_emailerror );
		form.email1.focus();
		return false;	
	} 
	
	var receiver= null;
	if (form.email1.value && form.email2.value == "0") {
		receiver = form.email1.value;
	} else {
		receiver = form.email1.value + "@" + form.email2.value;		
	}
	
	var url ='authEmail.jsp?email=' + receiver;
	open( url, "zipcode", "menubar=no, scrollbar=no, statusbar=no, width=400, height=300" );
}

function usezipcode() {
	var zc = null;
	var table = document.getElementById("zip_table");
	var form = null;
	if (typeof opener.document.inputform != "undefined") {
		form = opener.document.inputform;
	} else if (typeof opener.document.modifyform != "undefined") {
		form = opener.document.modifyform;
	}	
	
	for (var i = 1 ; i < table.rows.length; i++) { 
		if (table.rows[i].cells[2].children[0].checked == true) { 			
			zc = table.rows[i].cells[0].innerHTML;
			zc = zc.split("-");
			
			form.zipcode1.value = zc[0];
			form.zipcode2.value = zc[1];
			form.address1.value = table.rows[i].cells[1].innerHTML;			
			self.close();			
			return true;
		}		
	}
	
	alert("선택하세요");
	return false;
}

// 우편번호 찾기
function findZipcode() {
	// area 명 이용하기
	var url = "zipCheck.jsp?area=" + inputform.id.value;
	open( url, "zipcode", "menubar=no, scrollbar=no, statusbar=no, width=400, height=500" );		
}

function openZipcodePage() {
	open("zipCheck.jsp", "zipcode", "menubar=no, scrollbar=no, statusbar=no, width=400, height=500" );				
}

// 에러창
function erroralert( msg ) {
	alert( msg );
	// history.go(-1);	
	history.back();
}

function modifyfocus() {
	modifyform.passwd.focus();
}
function modifycheck() {	
	if( ! modifyform.passwd.value ) {
		alert( msg_passwderror );
		modifyform.passwd.focus();
		return false;
	} else if( modifyform.passwd.value
		!= modifyform.repasswd.value ) {
		alert( msg_repasswderror );
		modifyform.repasswd.focus();
		return false;
	}
	if (modifyform.auth_email.value == "0") {
		alert(msg_auth_email);
		modifyform.email1.focus();
		return false;
	}
	if( modifyform.email1.value || modifyform.email2.value ) {
		if( ! modifyform.email1.value 
			|| ! modifyform.email2.value  
			|| modifyform.email1.value.indexOf( '@' ) != -1  
			|| modifyform.email2.value.indexOf( '@' ) != -1	
			|| modifyform.email2.value.indexOf( '.' ) == -1 ) {
			alert( msg_emailerror );
			modifyform.email1.focus();
			return false;
		}
	}
	if( modifyform.tel1.value 
			|| modifyform.tel2.value
			|| modifyform.tel3.value ) {			
		
		if( modifyform.tel1.value.length < 3 
			|| modifyform.tel2.value.length < 4	
			|| modifyform.tel3.value.length < 4 ) {
			alert( msg_telerror );
			modifyform.tel1.focus();
			return false;
		} 			
	} 	
}

function modnexttel1() {
	if( modifyform.tel1.value.length == 3 ) {
		modifyform.tel2.focus();
	}		
}
function modnexttel2() {
	if( modifyform.tel2.value.length == 4 ) {
		modifyform.tel3.focus();
	}		
}
function modnexttel3() {
	if( modifyform.tel3.value.length == 4 ) {
		modifyform.email1.focus();
	}		
}


// 회원 탈퇴
function passwdfocus() {
	passwdform.passwd.focus();
}
function passwdcheck() {
	if( ! passwdform.passwd.value ) {
		alert( msg_passwderror );
		passwdform.passwd.focus();
		return false;
	}
}


// 로그인
function loginfocus() {
	loginform.id.focus();
}
function logincheck() {
	if( ! loginform.id.value ) {
		alert( msg_iderror );
		loginform.id.focus();
		return false;
	} else if( ! loginform.passwd.value ) {
		alert( msg_passwderror );
		loginform.passwd.focus();
		return false;
	} 
}


// 아이디 중복확인
function confirmid() {
	if( ! inputform.id.value ) {
		alert( msg_iderror );
		inputform.id.focus();
	} else {
		var url = "confirmId.jsp?id=" + inputform.id.value;
		open( url, "confirm", "menubar=no, scrollbar=no, statusbar=no, width=300, height=200" );		
	}	
}
function confirmfocus() {
	confirmform.id.focus();
}
function confirmcheck() {
	if( ! confirmform.id.value ) {
		alert( msg_iderror );
		confirmform.id.focus();
		return false;
	}
}

function useid( id ) {
	opener.document.inputform.id.value = id;
	opener.document.inputform.confirm.value = "1";
	self.close();
}

// 메인 페이지
function mainfocus() {
	mainform.id.focus();
}
function maincheck() {
	if( ! mainform.id.value ) {
		alert( msg_iderror );
		mainform.id.focus();
		return false;
	} else if( ! mainform.passwd.value ) {
		alert( msg_passwderror );
		mainform.passwd.focus();
		return false;
	}
}


// 회원가입
function inputfocus() {
	inputform.id.focus();
}
function inputcheck() {
	if( inputform.confirm.value == "0" ) {
		alert( msg_confirmerror );
		inputform.id.focus();
		return false;
	} 
	if (inputform.auth_email.value == "0") {
			alert(msg_auth_email);
			inputform.email1.focus();
			return false;
	}
	
	if( ! inputform.id.value ) {
		alert( msg_iderror );
		inputform.id.focus();
		return false;
	} else if( ! inputform.passwd.value ) {
		alert( msg_passwderror );
		inputform.passwd.focus();
		return false;
	} else if( inputform.passwd.value 
			!= inputform.repasswd.value ) {
		alert( msg_repasswderror );
		inputform.repasswd.focus();
		return false;
	} else if( ! inputform.name.value ) {
		alert( msg_nameerror );
		inputform.name.focus();
		return false;		
	} else if( ! inputform.jumin1.value 
			|| ! inputform.jumin2.value ) {
		alert( msg_juminerror );
		inputform.jumin1.focus();
		return false;
	} else if( inputform.jumin1.value.length < 6 
			|| inputform.jumin2.value.length < 7 ) {
		alert( msg_juminlength );
		inputform.jumin1.focus();
		return false;		
	} else if ( !inputform.zipcode1.value
			|| !inputform.zipcode2.value
			|| !inputform.address1.value) {
		alert( msg_ziperror );
		inputform.zipcode1.focus();
		return false;
	} else if (!inputform.address2.value) {
		alert( msg_adderror );
		inputform.address2.focus();
		return false;
	} else if( ! inputform.email2.value 
			&& inputform.email1.value ) {
		alert( msg_emailerror );
		inputform.email1.focus();
		return false;
	} else if( ( inputform.email2.value == '0' 
				&& inputform.email1.value.indexOf( '@' ) == -1 )
			|| ( inputform.email2.value != '0' 
				&& inputform.email1.value.indexOf( '@' ) != -1 ) ) {
		alert( msg_emailerror );
		inputform.email1.focus();
		return false;	
	} else if( inputform.tel1.value
			|| inputform.tel2.value 
			|| inputform.tel3.value ) {
		if( inputform.tel1.value.length < 3 
			|| inputform.tel2.value.length < 4
			|| inputform.tel3.value.length < 4 ) {
			alert( msg_telerror );
			inputform.tel1.focus();
			return false;
		} 			
	} 
}

function nextjumin1() {
	if( inputform.jumin1.value.length == 6 ) {
		inputform.jumin2.focus();
	}		
}
function nextjumin2() {
	if( inputform.jumin2.value.length == 7 ) {
		inputform.tel1.focus();
	}		
}
function nexttel1() {
	if( inputform.tel1.value.length == 3 ) {
		inputform.tel2.focus();
	}		
}
function nexttel2() {
	if( inputform.tel2.value.length == 4 ) {
		inputform.tel3.focus();
	}		
}
function nexttel3() {
	if( inputform.tel3.value.length == 4 ) {
		inputform.email1.focus();
	}		
}