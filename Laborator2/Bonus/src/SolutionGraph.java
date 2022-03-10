import java.io.*;
import java.sql.Time;
import java.util.*;

public class SolutionGraph {
    Event[] events;
    Room[] rooms;
    int[][] matrix;
    int nrRooms;
    int nrEvents;
    int[] colored;
    int[] saturation;
    int nrColors;
    int[] degree;
    //constructor
    public SolutionGraph(Room[] rooms, Event[] events) {
        this.rooms = rooms;
        this.events = events;
        nrRooms = rooms.length;
        nrEvents = events.length;
        nrColors = 0;
        matrix = new int[nrEvents][nrEvents];

        degree = new int[nrEvents];
        colored = new int[nrEvents];
        saturation = new int[nrEvents];

    }

    /**
     *  DSatur algorithm for graph coloring
     */
    void DSatur() {
        createMatrix();
        int coloredNodes = 0;
        while (coloredNodes < nrEvents) {
            int i = getMaxSaturation();
            colored[i] = getMinColor(i);
            //increase de saturation for all the vertix
            for (int j = 0; j < nrEvents; j++)
                if (matrix[i][j] == 1) {
                    saturation[j]++;
                }
            coloredNodes++;
        }
        printSolution();
    }

    /**
     * creates the adjacency matrix where events are nodes and edges are between conflicting events
     * and the degree vector
     */
    void createMatrix() {
        for (int i = 0; i < nrEvents; i++)
            for (int j = 0; j < nrEvents; j++) {
                if (!((events[i].startTime).compareTo(events[j].endTime)<0 && (events[i].startTime).compareTo(events[j].startTime)>=0 ) && i != j)
                {
                    matrix[i][j] = 1;
                    degree[i]=1;
                    degree[j]=1;
                }

            }
    }


    /**
     * gets the node with the max saturation that is not visited;
     */
    int getMaxSaturation() {
        int sat = 0;
        int index = 0;
        for (int i = 0; i < nrEvents; i++)
            if (saturation[i] >= sat && degree[i] >= sat && colored[i] == 0) {
                sat = saturation[i];
                index = i;
            }
        return index;
    }

    /**
     * get the most minimum color for node
     */
    int getMinColor(int node) {
        boolean[] used = new boolean[nrColors + 1];
        for (int i = 0; i < nrColors; i++)
            used[i] = false;
        for (int i = 0; i < nrEvents; i++)
            if (matrix[i][node] == 1)
                used[colored[i]] = true;
        for (int i = 0; i <= nrColors; i++)
            if (!used[i] &&rooms[colored[i]].capacity>=events[node].nrParticipant)
                return i;

        while(rooms[colored[nrColors]].capacity>=events[node].nrParticipant&&nrColors<nrRooms-1)
            nrColors++;
        return nrColors;
    }

    /**
     * prints the rooms and the events
     */
    void printSolution() {
        if (nrColors > nrRooms) {
            System.out.println("There are not enough rooms.");
        } else {
            for (int i = 0; i < nrEvents; i++) {
                System.out.println(events[i].getName()+ " -> " +rooms[colored[i]].getName() );
            }
        }
    }
}
