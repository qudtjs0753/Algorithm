package swexpert.data_structure;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeSet;

public class 끝말잇기2 {
    private HashSet<String> used;
    private TreeSet<String>[] wordList;
    private PlayerCycle players;
    public void init(int N, int M, char[][] mWords)
    {
        wordList = new TreeSet[26];
        used = new HashSet<>();
        for(int i=0; i<26; i++) {
            wordList[i] = new TreeSet<>();
        }

        //player 초기화
        players = new PlayerCycle(N);
        //String 추가
        for(int i=0; i<M; i++) {
            String str = createString(mWords[i]);
            wordList[str.charAt(0)-'a'].add(str);
        }
    }

    private String createString(char[] word) {
        StringBuilder sb = new StringBuilder();
        for (char c : word) {
            if (c == '\0') return sb.toString();
            sb.append(c);
        }

        return sb.toString();
    }
    public int playRound(int mID, char mCh)
    {
        Queue<String> wordsToAdd = new LinkedList<>();
        players.currentPoint = mID;

        //1. 뽑는다.
        //2. 사용된지 확인한다.
        while(!wordList[mCh-'a'].isEmpty()) {
            String currentWord = wordList[mCh-'a'].pollFirst();
            used.add(currentWord);
            String reversedWord = reverse(currentWord);
            wordsToAdd.add(reversedWord);
            players.next();
            mCh = currentWord.charAt(currentWord.length()-1);
        }

        //3. 이전에 사용되었던 것들 다 추가한다.
        while(!wordsToAdd.isEmpty()) {
            String candidate = wordsToAdd.poll();
            if(used.contains(candidate))continue;
            char ch = candidate.charAt(0);
            wordList[ch-'a'].add(candidate);
        }
        players.delete(players.currentPoint);

        return players.currentPoint;
    }

    private String reverse(String currentWord) {
        StringBuilder sb = new StringBuilder();
        for(int i=currentWord.length()-1; i>=0; i--) {
            sb.append(currentWord.charAt(i));
        }
        return sb.toString();
    }
}

class PlayerCycle {
    int currentPoint;
    int[] before, next;

    PlayerCycle(int N) {
        currentPoint = 1;
        this.before = new int[N+1];
        this.next = new int[N+1];
        createCycle(N);
    }

    void next() {
        currentPoint = next[currentPoint];
    }
    void createCycle(int N) {
        next[1] = 2;
        before[1] = N;
        next[N] = 1;
        before[N] = N-1;
        for(int i=2; i<N; i++) {
            next[i] = i + 1;
            before[i] = i - 1;
        }
    }

    void delete(int current) {
        next[before[current]] = next[current]; //건너서 다음으로 넘기는 작업.
        before[next[current]] = before[current]; //다음 녀석의 이전을 갱신.
    }
}

