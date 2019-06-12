appEventos.service('Cookie', function(){
	
	this.set = (name, value, duration)=> {
		console.log(duration);
		
		var cookie = `${name}=${escape(value)};expires=${duration.toUTCString()};`;

		document.cookie = cookie;
	}
	
	this.get = (name)=> {
		var cookies = document.cookie;
		var prefix = name + "=";
		var begin = cookies.indexOf("; " + prefix);

		if (begin == -1) {
			begin = cookies.indexOf(prefix);
			if (begin != 0) {
				return null;
			}
		} else {
			begin += 2;
		}
		var end = cookies.indexOf(";", begin);
		if (end == -1) {
			end = cookies.length;                        
		}
		return unescape(cookies.substring(begin + prefix.length, end));
	}
	
	this.delete = (name)=> {
		if (getCookie(name)) {
			document.cookie = name + "=" + "; expires=Thu, 01-Jan-70 00:00:01 GMT";
		}
	}
});