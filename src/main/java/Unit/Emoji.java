package Unit;

public interface Emoji {
    String monk  = "\u271D";
    String outlaw = "\uD83D\uDD2A";
    String sniper ="\uD83C\uDFF9";
    String mag = "\uD83E\uDDD9";
    String farmer = "\uD83D\uDD28";
    String crossbowman = "\uD83C\uDFF9";
    String spearman = "⚔️";
    String emojiDef = "\uD83D\uDEE1";
    String emojiAttack = "\u2694";
    String emojiHp = "\uD83E\uDDE1";
    String emojiDamage = "";
    String die = "\uD83D\uDC80";

     default String getEmoji(String emoji){
        if (emoji == "monk") return monk;
        if (emoji == "outlaw") return outlaw;
        if (emoji == "sniper") return sniper;
        if (emoji == "mag") return mag;
        if (emoji == "farmer") return farmer;
        if (emoji == "crossbowman") return crossbowman;
        if (emoji == "spearman") return spearman;
        if (emoji == "die") return die;
        if (emoji == "def") return emojiDef;
         return "null";
     }

}
