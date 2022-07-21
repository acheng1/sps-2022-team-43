// setup materialize components
document.addEventListener('DOMContentLoaded', function() {
    var modals = document.querySelectorAll('.modal');
    M.Modal.init(modals);
});

async function sendMessage() {
    const message = document.getElementById('text-input').value;
    const payload = await fetch(`/sentiment-analysis?text-input=${message}`);
    const { quote, score } = await payload.json();
    const dayId = new Date(new Date().getYear(), new Date().getMonth(), new Date().getDay(), 0, 0, 0, 0).toString();
    const dayContainer = document.getElementById(dayId);
    
    if (score < -0.5) {
        dayContainer.classList.add('calendar-day-bad');
    } else if (score < 0.5) {
        dayContainer.classList.add('calendar-day-average');
    } else {
        dayContainer.classList.add('calendar-day-happy');
    }

    const motivationalQuoteContainer = document.getElementById('motivational-quote');
    motivationalQuoteContainer.innerText = quote;
}

function renderCalendar(calendarData) {
    const calendarContainer = document.getElementById('calendar-container');
    const months = Array.from(Array(12).keys());
    for (const month of months) {
        const monthContainer = document.createElement('div');
        const monthContainerTitle = document.createElement('div');
        monthContainer.classList.add('calendar-month');
        monthContainerTitle.classList.add('calendar-month-title');
        const date = new Date(new Date().getYear(), month, 0);
        const monthName = date.toLocaleString('en-US', { month: 'short' });
        const daysInMonth = date.getDate();

        monthContainerTitle.innerText = monthName;
        monthContainer.appendChild(monthContainerTitle);
        

        let i = 0;
        while (i++ < daysInMonth) {
            const dayContainer = document.createElement('div');
            const date = new Date();
            dayContainer.id = new Date(new Date().getYear(), month, i, 0, 0, 0, 0).toString();
            dayContainer.classList.add('calendar-day');
            dayContainer.innerText = i;
            monthContainer.appendChild(dayContainer);
        }
        
        calendarContainer.appendChild(monthContainer);
        
    }
}