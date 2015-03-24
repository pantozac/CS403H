package myProject

import scala.collection.mutable.Stack
import scala.util.Random

class Player (val name:String, val seat:Int){

}

class Card (val rank: Int, val suit: String){
  private val validSuits:Array[String]=Array("Heart","Club","Spade","Diamond")
  private val validRanks:Array[Int]=Array(2,3,4,5,6,7,8,9,10,11,12,13,14)
  def isValid:Boolean=validSuits.contains(suit)&&validRanks.contains(rank)
  def isHeart:Boolean= (suit=="Heart")
  def isClub:Boolean= (suit=="Club")
  def isSpade:Boolean=(suit=="Spade")
  def isDiamond:Boolean=(suit=="Diamond")
  def isHigher(compare:Card):Boolean=(rank>compare.rank)
}




class Deck (val name: String, var cards: Stack[Card]){
	def showContents= cards
	def isEmpty= cards.isEmpty
	def topCard= cards.head
	def deal= cards.pop()
	def length=cards.length
  def shuffle={
    cards=Random.shuffle(cards)
  }
}

class Hand (val player: Player, var cardArray: Array[Card]){
	private val nullCard=new Card(-1,null)
  def init = {
		val blank=Array.fill[Card](13)(nullCard)
		this.cardArray=blank
	}
	def showPlayer= this.player
	def showCards= this.cardArray
	def draw(deck: Deck)={
		if (deck.isEmpty) this.cardArray
		else{
			for (index<- 0 until this.cardArray.length-1){
				if (this.cardArray(index)==nullCard){
					this.cardArray(index)=deck.deal
				}
			}
		}
	}
 def play(index:Int)= {
   if (cardArray(index)!=nullCard){
     val playedCard=cardArray(index)
     cardArray(index)=nullCard
     playedCard
   }
   else nullCard
 }
}
//Deleted the discard pile class because it's not needed for implimentation

class PlayArea(var score:Int, var lead: String){
  val cards= Array.ofDim[Card](4)
  def max: Int= ???
}

class Scoreboard{
  def init:Int= ???
}

class TurnQueue{
}

class SimControll{
  val twoHeart=new Card(2,"Heart")
  val threeHeart=new Card(3,"Heart")
  val fourHeart=new Card(4,"Heart")
  val fiveHeart=new Card(5,"Heart")
  val sixHeart=new Card(6,"Heart")
  val sevenHeart=new Card(7,"Heart")  
  val eightHeart=new Card(8,"Heart")
  val nineHeart=new Card(9,"Heart")
  val tenHeart=new Card(10,"Heart")
  val jackHeart=new Card(11,"Heart") 
  val queenHeart=new Card(12,"Heart")
  val kingHeart=new Card(13,"Heart")
  val aceHeart=new Card(14,"Heart")
  val twoSpade=new Card(2,"Spade")
  val threeSpade=new Card(3,"Spade")
  val fourSpade=new Card(4,"Spade")
  val fiveSpade=new Card(5,"Spade")
  val sixSpade=new Card(6,"Spade")
  val sevenSpade=new Card(7,"Spade")  
  val eightSpade=new Card(8,"Spade")
  val nineSpade=new Card(9,"Spade")
  val tenSpade=new Card(10,"Spade")
  val jackSpade=new Card(11,"Spade") 
  val queenSpade=new Card(12,"Spade")
  val kingSpade=new Card(13,"Spade")
  val aceSpade=new Card(14,"Spade")
  val twoClub=new Card(2,"Club")
  val threeClub=new Card(3,"Club")
  val fourClub=new Card(4,"Club")
  val fiveClub=new Card(5,"Club")
  val sixClub=new Card(6,"Club")
  val sevenClub=new Card(7,"Club")  
  val eightClub=new Card(8,"Club")
  val nineClub=new Card(9,"Club")
  val tenClub=new Card(10,"Club")
  val jackClub=new Card(11,"Club") 
  val queenClub=new Card(12,"Club")
  val kingClub=new Card(13,"Club")
  val aceClub=new Card(14,"Club")
  val twoDiamond=new Card(2,"Diamond")
  val threeDiamond=new Card(3,"Diamond")
  val fourDiamond=new Card(4,"Diamond")
  val fiveDiamond=new Card(5,"Diamond")
  val sixDiamond=new Card(6,"Diamond")
  val sevenDiamond=new Card(7,"Diamond")  
  val eightDiamond=new Card(8,"Diamond")
  val nineDiamond=new Card(9,"Diamond")
  val tenDiamond=new Card(10,"Diamond")
  val jackDiamond=new Card(11,"Diamond") 
  val queenDiamond=new Card(12,"Diamond")
  val kingDiamond=new Card(13,"Diamond")
  val aceDiamond=new Card(14,"Diamond")
  val standardDeck = new Deck("Standard",Stack[Card](twoHeart,threeHeart,fourHeart,fiveHeart,sixHeart,sevenHeart,
      eightHeart,nineHeart,tenHeart,jackHeart,queenHeart,kingHeart,aceHeart,twoSpade,threeSpade,
      fourSpade,fiveSpade,sixSpade,sevenSpade,eightSpade,nineSpade,tenSpade,jackSpade,queenSpade,
      kingSpade,aceSpade,twoClub,threeClub,fourClub,fiveClub,sixClub,sevenClub,eightClub,nineClub,
      tenClub,jackClub,queenClub,kingClub,aceClub,twoDiamond,threeDiamond,fourDiamond,fiveDiamond,
      sixDiamond,sevenDiamond,eightDiamond,nineDiamond,tenDiamond,jackDiamond,queenDiamond,kingDiamond,aceDiamond))
  var round=0
}

//winner check method not needed because a method can be instituted in the scoreboard


