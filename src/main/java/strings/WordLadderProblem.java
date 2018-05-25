package strings;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class WordLadderProblem {

  public static class QNode {
    String word;
    int len;

    public QNode(String word, int len) {
      this.word = word;
      this.len = len;
    }

    @Override
    public String toString() {
      return "QNode{" +
          "word='" + word + '\'' +
          ", len=" + len +
          '}';
    }
  }

  public static boolean isAdjacent(String s1, String s2) {
    int count = 0;
    for (int i = 0; i < s1.length(); i++) {
      if(s1.charAt(i) != s2.charAt(i)) count++;
      if(count > 1 ) return false;
    }
    return count == 1;
  }

  public static QNode isPossibleToTransform(String source, String target, Set<String> dictionay) {
    Queue<QNode> q = new LinkedList<>();
    q.offer(new QNode(source, 0));
    while (!q.isEmpty()) {
      QNode temp = q.poll();
      if(temp.word.equals(target)) {
       return temp;
      }
      Iterator<String> iterator = dictionay.iterator();
      while (iterator.hasNext()) {
        String s = iterator.next();
        if(isAdjacent(s, temp.word)) {
          q.offer(new QNode(s, temp.len + 1));
          iterator.remove();
        }
      }
    }
    return null;
  }

  public static void main(String[] args) {
    //
    Set<String> dictionary = new HashSet<>();
    dictionary.add("POON");
    dictionary.add("PLEE");
    dictionary.add("SAME");
    dictionary.add("POIE");
    dictionary.add("PLEA");
    dictionary.add("PLIE");
    dictionary.add("POIN");
    System.out.println(isPossibleToTransform("TOON", "PLEA", dictionary));
  }
}
