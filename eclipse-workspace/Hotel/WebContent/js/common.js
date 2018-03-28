(function($){
	$(document).ready(function(){
		// 메인메뉴
		var menu, menuLi, menuLink;
		menu = $("#lnb");
		menuLi = $("#lnb > li");
		menuLink = $("#lnb > li > a");
		/*menuLink.on("click", function(){
			if($(this).parent("li:has(ul)").length > 0){
				menuLi.not($(this).parent("li")).removeClass("on");
				$(this).parent("li").addClass("on");
				$(this).next("ul").children("li").removeClass("on");
				$(this).next("ul").children("li:first-child").addClass("on");
				//menuLi.find("ul li").not($(this).parent("li").find("ul li.on")).removeClass("on");
				/*$(this).next("ul").children("li").each(function(){
					if($(this).hasClass("on").length < 1){
						$(this).next("ul").children("li:first-child").addClass("on");
					}
				});*/
				//$(this).parent("li").find("ul").stop().slideDown(250);
				/*return false;
			}
		});*/

		function activeMenu(){
			var active = menuLi.find("ul li.on");
			active.parent().parent().addClass("on");
			$("#lnb > li.on").find("ul").show();
		}
		activeMenu();

		// [START] fadein & fadeout (author : KANG HEE CHANG)
		function fadeGallery(obj, timer){
			var $speed = 500;
			var $wrapper = "#" + obj;
			var $sel = 0;
			var flag = true

/*			$($wrapper).find(".gallery").children("li:gt(0)").hide();*/
			$($wrapper).find(".control").children("li:first-child").addClass("on");
			if($($wrapper).find(".gallery").children("li").length==1){
				$($wrapper).find(".links_prev, .links_next").hide();
				return false;
			}
			function goNext(){
				if(flag == true){
					flag = false;
					$sel++;
					$($wrapper).find(".page").children(".t_point").text($sel+1);
					if($sel == $($wrapper).find(".gallery").children("li").size()){
						$sel = 0;
						$($wrapper).find(".page").children(".t_point").text($sel+1);
					}
					$($wrapper).find(".control").children("li").eq($sel).addClass("on");
					$($wrapper).find(".control").children("li").not($($wrapper).find(".control").children("li").eq($sel)).removeClass("on");
					$($wrapper).find(".gallery").children("li")
						.fadeOut()
						.eq($sel).fadeIn(function(){flag = true;});
				}
				return false;
			}
			$($wrapper).find(".links_next").click(goNext);

			function goPrev(){
				if(flag == true){
					flag = false;
					$sel--;
					$($wrapper).find(".page").children(".t_point").text($sel+1);
					if($sel == -1){
						$sel = $($wrapper).find(".gallery").children("li").size() - 1;
						$($wrapper).find(".page").children(".t_point").text($sel+1);
					}
					$($wrapper).find(".control").children("li").eq($sel).addClass("on");
					$($wrapper).find(".control").children("li").not($($wrapper).find(".control").children("li").eq($sel)).removeClass("on");
					$($wrapper).find(".gallery").children("li")
						.fadeOut()
						.eq($sel).fadeIn(function(){flag = true;});
				}
				return false;
			}
			$($wrapper).find(".links_prev").click(goPrev);

			// 바로가기
			function goDirect(){
				if(flag == true && !$(this).parent().hasClass("on")){
					flag = false;
					$sel = $(this).parent().index();
					$($wrapper).find(".page").children(".t_point").text($sel+1);
					$(this).parent("li").addClass("on");
					$($wrapper).find(".control").children("li").not($(this).parent("li")).removeClass("on");
					$($wrapper).find(".gallery").children("li")
						.fadeOut()
						.eq($sel).fadeIn(function(){flag = true;});
				}
				return false;
			}
			$($wrapper).find(".control a").click(goDirect);

			// 자동실행
			var autoPlay;
			function autoChange(){
				autoPlay = setInterval(goNext, timer);
			}
			autoChange();

			// 영역 오버시 멈춤
/*
			$($wrapper).hover(
				function(){
					clearInterval(autoPlay);
				},
				function(){
					autoChange();
				}
			);
*/
			// 컨트롤러
			$($wrapper).find(".links_stop").click(function(){
				clearInterval(autoPlay);
				$(this).removeClass("active").next().addClass("active");
			});
			$($wrapper).find(".links_play").click(function(){
				autoChange();
				$(this).removeClass("active").prev().addClass("active");
			});
		}

		// 호출함수(아이디, 딜레이)
		if($("#mBytree").length>0){
			fadeGallery("mBytree", 4500);
		}
		if($("#mPromo").length>0){
			fadeGallery("mPromo", 400000000);
		}
		if($("#mPromotion").length>0){
			fadeGallery("mPromotion", 400000000);
		}
		if($("#mVisual").length>0){
			fadeGallery("mVisual", 400000000);
		}
		// [END] fadein & fadeout

		// 목록 테이블 셀 디자인
		if($("table.cell_design").length>0){
			$("table.cell_design").each(function(){
				$(this).find("tbody").children("tr:odd").addClass("even");
			});
		}
		if($("table.cell_design").length>0){
			$("table.cell_design").each(function(){
				$(this).find("tbody").children("tr:odd").addClass("even");
			});
		}
		if($(".list_cell_design").length>0){
			$(".list_cell_design").each(function(){
				$(this).find("li:even").addClass("odd");
			});
		}

		// 공통탭
		$(".tab > li > a[href^=#tab]").on("click", function(){
			var view = $(this).attr("href");
			$(".tab_cont[id]").removeClass("on");
			$(view).addClass("on");
			$(this).parents(".tab").children("li").removeClass("on");
			$(this).parent().addClass("on");
			return false;
		});

		// Scrubs
		if($("#divScrubs").length > 0){
			$("#divScrubs").addClass("hide");
		}
		$(".btn_scrubs").on("click", function(){
			if($(this).hasClass("on")){
				$("#divScrubs").addClass("hide");
				$(this).removeClass("on");
				//$(this).find("em").text("스크럽 종류보기");
			}else{
				$("#divScrubs").removeClass("hide");
				$(this).addClass("on");
				//$(this).find("em").text("스크럽 종류닫기");
			}
			return false;
		});

		// Photo & Video
		if($("#divProduct").find(".list_product").children("li").length >= 5){
			$("#divProduct.pv_wrap .more").on("click", function(){
				if($("#divProduct.pv_wrap").children(".box_basic").hasClass("on")){
					$("#divProduct.pv_wrap").children(".box_basic").removeClass("on");
					$(this).text("전체보기");//.attr("title","관련 사진과 동영상 전체보기")
					
				}else{
					$("#divProduct.pv_wrap").children(".box_basic").addClass("on")
					$(this).text("닫기");//.attr("title","관련 사진과 동영상 닫기");
					
				}
				return false;
			});
		}else{
			$("#divProduct.pv_wrap .more").hide();
			/*if($("#divProduct").find(".list_product").children("li").length == 1 && $("#divProduct").find(".list_product").children("li").has("a"))$("#divProduct").find(".list_product").children("li").addClass("pro_noinfo");	*/
		}

		// select decoration
		if($(".select_wrap").length>0){
			$(".select_wrap").each(function(){
				$(this).find(".head a span").text($(this).find("li.on a").text());
			});
		};
		$(".select_wrap .head a").on("click", function(){
			if($(this).parents(".select_wrap").hasClass("on")){
				$(this).parents(".select_wrap").removeClass("on");
			}else{
				$(this).parents(".select_wrap").addClass("on");
			}
			return false;
		});
		$(".select_wrap").find("li a").on("click", function(){
			$(this).parents(".select_wrap").find(".head input:hidden").val($(this).text());
			$(this).parents(".select_wrap").find(".head a span").text($(this).text());
			$(this).parents(".select_wrap").removeClass("on");
		//return false;
		});
		$(".select_wrap").on("mouseleave", function(){
			$(".select_wrap").removeClass("on");
		});

		// 반얀트리 가이드맵
		if($(".bytree_wrap").length>0){
			$(".bytree_wrap .details:eq(0)").addClass("on");
			var imgName = $(".bytree_wrap .location img").attr("src");
				
			$(".list_location li").children("a").on("click", function(){
				var num = $(this).parent().index();
				$(".bytree_wrap .location img").attr("src", ".."+imgName.match(/[^\.]+/)+(num+1)+".png");
				$(".bytree_wrap .details").removeClass("on");
				$(this).next(".details").addClass("on");
				$(".list_location li").children("a").removeClass("on");
				 $(this).addClass("on");
				return false;
			});
			//$(".list_location li:first-child").children("a:first-child").click();
		}
		
		// layerpop
		$("a[href^=#layer_]").bind("click", function(){
			$($(this).attr("href")).show();
			//$($(this).attr("href")).css("top",$(window).scrollTop()+"px");
		});
		$(".layerpop .btn_close").bind("click", function(){
			$(this).parents(".layerpop").hide();
			var $parentsID = $(this).parents(".layerpop").attr("id");
			$("a[href=#"+$parentsID+"]").focus();

			// Moon Bar
			if($parentsID=="layer_video"){
				var video = $("#"+$parentsID).find(".cont").html();
				$("#"+$parentsID).find(".cont").children().remove();
				$("#"+$parentsID).find(".cont").html(video);
			}
			return false;
		});
	});

	/*팝업 오픈*/
	$("#pop_open_rate").click(function(){
		window.open("/web/01_about/rack_rate_p01.html" , "popup01", "scrollbars=yes, width=382, height=600, left=400, top=200")
	});

})(jQuery);

/* cssInsert */
function cssInsert(){
	$(".tb_abc tr:nth-child(2n)").css("background-color","#4c4c4c");
	$(".tb_abc tr:last-child td").css("border-bottom","1px solid #535353");
}

/* cssDelete */
function cssDelete(){
	$(".tb_abc tr:last-child td").css("border-bottom","1px solid #535353");
}


/* 탭 활성화 */
function tab_view(selectIndex){
	$( ".tab > li > a[href^=#tab]" ).each(function( index ) {
		if(selectIndex == index){
			var view = $(this).attr("href");
			$(".tab_cont[id]").removeClass("on");
			$(view).addClass("on");
			$(this).parents(".tab").children("li").removeClass("on");
			$(this).parent().addClass("on");
		}
	});
}



/* 기능 활성화 */
$(document).ready(function(){
	cssInsert();
	cssDelete();
});