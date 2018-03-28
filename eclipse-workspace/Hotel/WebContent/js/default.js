/* 페이스북 */
function pstFaceBook( v_url, v_img, v_title, v_msg) {
	var url = v_url;
	var img = v_img;
	var title = v_title;
	var msg = v_msg;

	var href = "http://www.facebook.com/sharer.php?s=100&p[url]="+ url +"&p[images][0]="+ img +"&p[title]="+ encodeURIComponent(title) +"&p[summary]="+ encodeURIComponent(msg);

	var a = window.open(href, 'facebookpost', '');
	if ( a ) {
		a.focus();
	}
}

/* 트위터 */
function pstTwitter(v_msg) {
	var href = "https://twitter.com/intent/tweet?text="+ encodeURIComponent(v_msg);
//	var href = "http://twitter.com/home?status=" + encodeURIComponent(msg);
	var a = window.open(href, 'twitterpost', '');
	if ( a ) {
		a.focus();
	}
}

/* kakao 링크 전달 */
function kakao_share(v_url, v_msg){
    /* 
    msg, url, appid, appname은 실제 서비스에서 사용하는 정보로 업데이트되어야 합니다. 
    */
    kakao.link("talk").send({
        msg : v_msg,
        url : v_url,
        appid : "www.banyantreeclub.com",
        appver : "2.0",
        appname : "banyantreeclub",
        type : "link"
    });
}

//-- 페이지 이동
function goto_page( v_page ){
	var fm = document.getElementById("pagefm");
	if(fm.act_url) fm.action=fm.act_url.value;
	if(fm.act_target) fm.target=fm.act_target.value;
	if(fm.act_method) fm.method=fm.act_method.value;
	fm.page.value = v_page;
	fm.submit();
}

/* 쿠키 구하기  */
function getCookie( name ) {
	var nameOfCookie = name + "=";
	var x = 0;
	while ( x <= document.cookie.length ) {
		var y = (x+nameOfCookie.length);
		if ( document.cookie.substring( x, y ) == nameOfCookie ) {
			if ( (endOfCookie=document.cookie.indexOf( ";", y )) == -1 ) 
				endOfCookie = document.cookie.length;

			return unescape( document.cookie.substring( y, endOfCookie ) );
		}
		x = document.cookie.indexOf( " ", x ) + 1;
		if ( x == 0 )
			break;  
	}
	return "";
}

/* 쿠키 설정  */
function setCookie( name, value, expiredays )  { 
	var todayDate = new Date(); 
	todayDate.setDate( todayDate.getDate() + expiredays ); 
	document.cookie = name + "=" + escape( value ) + "; path=/; expires=" + todayDate.toGMTString() + ";" 
} 
