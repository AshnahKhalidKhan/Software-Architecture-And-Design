public class Stopwatch implements TimeDevice, ShowsMinutes, ShowsSeconds, ShowsMilliseconds
{
    private Minutes minutes;
    private Seconds seconds;
    private Milliseconds milliseconds;
    
    public Stopwatch()
    {
        minutes = new Minutes();
        seconds = new Seconds();
        milliseconds = new Milliseconds();
    }
    
    public void setTime(int minutes, int seconds, int milliseconds)
    {
        this.minutes = new Minutes();
        this.seconds = new Seconds();
        this.milliseconds = new Milliseconds();
        seconds = seconds + this.milliseconds.changeInNextTimeUnit(milliseconds);
        minutes = minutes + this.seconds.changeInNextTimeUnit(seconds);
        setMilliseconds(milliseconds);
        setSeconds(seconds);
        setMinutes(minutes);
    }
    
    // ml, s, min
    // 5050, 70, 40
    // 50, 70 + 5, 40
    // 50, 15, 40 + 1
    // 50, 15, 41
    public void setMilliseconds(int milliseconds)
    {
        // changeSeconds(this.milliseconds.changeInNextTimeUnit(milliseconds));
        this.milliseconds.setTime(milliseconds);
    }
    
    public void changeMilliseconds(int changeInMilliseconds)
    {
        changeSeconds(this.milliseconds.changeInNextTimeUnit(changeInMilliseconds));
        this.milliseconds.changeTimeBy(changeInMilliseconds);
    }
    
    public void setSeconds(int seconds)
    {
        // changeMinutes(this.seconds.changeInNextTimeUnit(seconds));
        this.seconds.setTime(seconds);
    }
    
    public void changeSeconds(int changeInSeconds)
    {
        changeMinutes(this.seconds.changeInNextTimeUnit(changeInSeconds));
        this.seconds.changeTimeBy(changeInSeconds);
    }
    
    public void setMinutes(int minutes)
    {
        this.minutes.setTime(minutes);
    }
    
    public void changeMinutes(int changeInMinutes)
    {
        this.minutes.changeTimeBy(changeInMinutes);
    }
    
    public String displayTime()
    {
        return this.minutes.displayTime() + " " + this.seconds.displayTime() + " " + this.milliseconds.displayTime();
    }
}