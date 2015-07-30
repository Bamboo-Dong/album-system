
function addLoadEvent(func) {
  var oldonload = window.onload;
  if (typeof window.onload != 'function') {
    window.onload = func;
  } else {
    window.onload = function() {
      oldonload();
      func();
    }
  }
}

function showSection(id) {
	var sections = document.getElementsByTagName("section");
	for(var i=0;i<sections.length;i++) {
		if(sections[i].getAttribute("id") != id) {
			sections[i].style.display = "none";
		}else {
			sections[i].style.display = "block";
		}
	}
}
function changeColor(id) {
	var navs = document.getElementsByTagName("nav");
	var links = navs[0].getElementsByTagName("a");
	for (var i = 0; i <links.length; i++) {
		var sectionId = links[i].getAttribute("href").split("#")[1];
		if(sectionId == id){
			links[i].parentNode.className = "special";
		}else {
			links[i].parentNode.className = "";
		}
	}
}

function getId() {
	var navs = document.getElementsByTagName("nav");
	var links = navs[0].getElementsByTagName("a");
	for (var i = 0; i <links.length; i++) {
		var secId = links[i].getAttribute("href").split("#")[1];
		if (!document.getElementById(secId)) continue;
		document.getElementById(secId).style.display = "none";
		document.getElementById("album").style.display = "block";
		links[i].destination = secId;
		links[i].onclick = function() {
			showSection(this.destination);
			changeColor(this.destination);
			return false;
		}

	};
}
function showForm() {
	var create = document.getElementById("create");
	var bg = document.getElementsByClassName("background")[0];
	var form = document.getElementById("form");
	var links = document.getElementsByClassName("close");
	for(var i=0;i<links.length;i++) {
		links[i].onclick = function() {
		form.style.display = "none";
		bg.style.display = "none";
		}
	}
	create.onclick = function() {
		form.style.display = "block";
		bg.style.display = "block";
	}
	
}

addLoadEvent(getId);
addLoadEvent(showForm);








