public class Solution {
    Room rooms[];
    Event events[];

    public Solution(Room[] rooms, Event[] events) {
        this.rooms = rooms;
        this.events = events;
    }
    /*
    *first i am ordering the events based on their starttime
    *in this function i compare the starttime of events to the final time of the last event in a specific room to see if it's okey to place the event there
    */
    public void Distribution()
    {
        for(int i=0;i<events.length-1;i++)
            for(int j=i+1;j< events.length;j++)
                if(events[i].startTime>events[j].startTime)
                {
                    Event aux=events[i];
                    events[i]=events[j];
                    events[j]=aux;
                }
        for(int i=0;i<events.length;i++)
        {
            for(int j=0;j< rooms.length;j++)
                if(events[i].startTime>=rooms[j].finalTimeEvent && events[i].nrParticipant<=rooms[j].capacity)
                {
                    System.out.println(events[i].name+" -> "+rooms[j].name);
                    rooms[j].finalTimeEvent=events[i].endTime;
                    break;
                }
        }

    }
}
