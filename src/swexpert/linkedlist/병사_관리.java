package swexpert.linkedlist;

import java.io.*;
import java.util.*;

public class 병사_관리 {

    static final int MAX_NODE = 200055;
    Node[] node = new Node[MAX_NODE];
    public int count = 0;
    public int[] version = new int[100055];
    public int[] teamForSoldier = new int[100055];

    public Node getNewNode(int id, Node next) {
        Node ret = node[count++];
        ret.id = id;
        ret.next = next;
        ret.value = ++version[id];
        return ret;
    }

    public class Team {
        Node[] head = new Node[6];
        Node[] tail = new Node[6];
    }

    public Team[] team = new Team[6];

    public void init() {
        count = 0;
        for(int i=0; i<MAX_NODE; i++) {
            if(node[i]==null) node[i] = new Node();
        }

        for(int i=1; i<=5; i++) {
            team[i] = new Team();
            for(int j=1; j<=5; j++) {
                team[i].tail[j] = team[i].head[j] = getNewNode(0, null);
            }
        }

        for(int i=0; i<=100000; i++) {
            version[i] = 0;
            teamForSoldier[i] = 0;
        }
    }

    public void hire(int mID, int mTeam, int mScore) {
        Node newNode = getNewNode(mID, null);
        team[mTeam].tail[mScore].next = newNode; //현재 마지막 노드의 다음 노드로 가리키게
        team[mTeam].tail[mScore] = newNode; //마지막 노드 변경
        teamForSoldier[mID] = mTeam;
    }

    public void fire(int mID) {version[mID] = -1;}//실제 삭제가 아니라 그냥 -1로 표기

    public void updateSoldier(int mID, int mScore) {
        hire(mID, teamForSoldier[mID], mScore);
    }

    public void updateTeam(int mTeam, int mChangeScore) {
        if (mChangeScore<0) {
            for (int score=1; score<=5; score++) {
                int newScore = score+mChangeScore;
                newScore = newScore < 1 ? 1 :(newScore);
                if(score==newScore) continue;
                if(team[mTeam].head[score].next==null) continue;

                team[mTeam].tail[newScore].next = team[mTeam].head[score].next;
                team[mTeam].tail[newScore] = team[mTeam].tail[score];
                team[mTeam].head[score].next = null;
                team[mTeam].tail[score] = team[mTeam].head[score];
            }
        }

        if (mChangeScore > 0) {
            for (int score = 5; score >= 1; score--) {
                int newScore = score + mChangeScore;
                newScore = newScore > 5  ? 5 : newScore;
                if (score == newScore) continue;

                if (team[mTeam].head[score].next == null) continue;
                team[mTeam].tail[newScore].next = team[mTeam].head[score].next;
                team[mTeam].tail[newScore] = team[mTeam].tail[score];
                team[mTeam].head[score].next = null;
                team[mTeam].tail[score] = team[mTeam].head[score];
            }
        }
    }
    public int bestSoldier(int mTeam) {
        for (int score = 5; score >= 1; score--) {
            Node node = team[mTeam].head[score].next;
            if (node == null) continue;

            int ans = 0;
            while (node != null) {
                if (node.value == version[node.id]) {
                    ans = ans < node.id ? node.id : ans;
                }
                node = node.next;
            }
            if (ans != 0) return ans;
        }
        return 0;
    }

    public class Node {
        int id;
        int value;
        Node next;

        Node() {

        }

        Node(int id, int value) {
            this.id=id;
            this.value = value;
        }

        Node(int id, int value, Node next) {
            this.id =id;
            this.value = value;
            this.next = next;
        }
    }
}
