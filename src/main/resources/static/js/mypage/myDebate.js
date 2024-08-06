function openTab(tabName) {
    // 모든 탭 컨텐츠를 숨깁니다.
    const tabContents = document.querySelectorAll('.body_tab');
    tabContents.forEach(tabContent => {
        tabContent.classList.remove('body_tab--active');
        tabContent.setAttribute('aria-hidden', 'true')
    });

    // 모든 탭을 비활성화합니다.
    const tabs = document.querySelectorAll('.body_tab');
    tabs.forEach(tab => {
        tab.classList.remove('active');
    });

    // 선택한 탭 컨텐츠를 표시합니다.
    const activeTabContent = document.getElementById(tabName);
    activeTabContent.classList.add('active');
    activeTabContent.setAttribute('aria-hidden' , 'false');

    // 선택한 탭을 활성화합니다.
    const activeTab = document.getElementById('tab-' + tabName);
    activeTab.classList.add('active');
}
