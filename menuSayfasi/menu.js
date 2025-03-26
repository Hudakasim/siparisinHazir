function showMenu(menuId) {
	// tüm menüleri gizle
	const sections = document.querySelectorAll('.menu-section');
	sections.forEach(section => {
	  section.style.display = 'none';
	});

	// seçilen menüyü göster
	const activeSection = document.getElementById('menu-' + menuId);
	if (activeSection) {
	  activeSection.style.display = 'block';
	}
  }
