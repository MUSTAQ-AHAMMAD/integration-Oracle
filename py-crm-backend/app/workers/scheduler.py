from apscheduler.schedulers.background import BackgroundScheduler
from apscheduler.triggers.interval import IntervalTrigger

scheduler = BackgroundScheduler()


def start_scheduler() -> None:
    if scheduler.running:
        return

    def heartbeat():
        return "ok"

    scheduler.add_job(heartbeat, IntervalTrigger(minutes=5), id="heartbeat", replace_existing=True)
    scheduler.start()


def stop_scheduler() -> None:
    if scheduler.running:
        scheduler.shutdown(wait=False)
