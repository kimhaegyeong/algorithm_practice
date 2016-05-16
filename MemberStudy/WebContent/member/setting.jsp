<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- 회원관리 -->
<%
	String page_main = "메인 페이지";
	String page_input = "회원 가입";
	String page_confirm = "아이디 중복확인";
	String page_login = "로그인";
	String page_delete = "회원 탈퇴";
	String page_modify = "회원 정보 수정";
	String page_zipcode = "우편번호 찾기";
	String page_authmail = "이메일 인증하기";

	String msg_main = "비회원이시면 회원가입을 해주세요";
	String msg_login = "님 안녕하세요";			
	String msg_input = "회원정보를 입력해주세요";
	String msg_id_x = "는 사용할 수 없습니다";
	String msg_id_o = "는 사용할 수 있습니다";
	String msg_login_ok = "가입 확인을 위해서 로그인해주세요";
	String msg_passwd = "비밀번호를 다시 입력해주세요";
	String msg_modify = "수정할 정보를 입력해주세요";	
	String msg_sending_email = "이메일 전송 중입니다.";
	String msg_sended_email = "이메일 전송 되었습니다.\n인증번호를 입력하세요.";
	
	String str_id = "아이디";
	String str_passwd = "비밀번호";
	String str_name = "이름";
	String str_jumin = "주민등록번호";
	String str_tel = "전화번호";
	String str_email = "이메일";
	String str_reg_date = "가입일자";
	String str_address = "주소";
	String str_zipcode = "우편번호";
	String str_email_title = "test - 인증 메일 전송";
	String str_email_content = "인증번호는 다음과 같습니다\n";
	
	String btn_login = "로그인";
	String btn_cancel = "취소";
	String btn_input = "회원가입";
	String btn_modify = "정보수정";
	String btn_delete = "회원탈퇴";
	String btn_logout = "로그아웃";
	String btn_join = "가입";
	String btn_join_cancel = "가입취소";
	String btn_confirm = "중복확인";
	String btn_ok = "확인";
	String btn_ok_cancel = "확인취소";
	String btn_login_cancel = "로그인취소";
	String btn_del = "탈퇴";
	String btn_del_cancel = "탈퇴취소";
	String btn_mod = "수정";
	String btn_mod_cancel = "수정취소";
	String btn_zipcode = "우편주소검색";
	String btn_sendmail = "인증번호";
%>