package myProject

import org.scalatest.FunSpec
import org.scalatest.Matchers

class heartsTest extends FunSpec with Matchers {

  describe("A Player") {
    it ("should have a name"){
      val player= new Player("player1",0)
      assert (player.name != null)
    }
    it ("should have a seat value less than 4"){
      val player= new Player("player1",0)
      assert (player.seat < 4)
      }
  }
  
  describe ("a Deck"){
    describe("before a hand"){
      it("has 52 cards"){
      val deck= new Deck("standard", null)
      assert (deck.length==52)  
      }
      
      it("has no repeated elements"){
        val deck= new Deck("standard",null)
        var mover=Set[Card]()
        while (!deck.isEmpty) mover+=deck.deal
        assert (mover.size==52)
        }
      
      it("is shuffled"){
        val deck = new Deck("standard",null)
        val copyDeck= deck
        deck.shuffle
        assert (deck.showContents!=copyDeck.showContents)
      }
      }
    describe("after dealt"){
      it("is empty"){
      var deck= new Deck("standard",null)
      assert (deck.length==0)
      }
    }
  }
  
  describe("a player's Hand"){
    it("belongs to a player"){
      val hand=new Hand(null, null)
      assert (hand.player !=null)
    }
    
    describe("at the start of a hand"){
      it ("has 13 cards"){
        val hand=new Hand(null,null)
        assert (hand.cardArray.length==13)
      }
      it ("has no repeated elements"){
        val hand = new Hand(null, null)
        var flag = true
        var mover=Set[Card]()
        for (item<-0 until hand.cardArray.length){
            mover+=hand.play(item)
        }
        assert (mover.size==13)
      }
    }
    describe("during a turn"){
      it ("plays a valid card"){
        val hand=new Hand(null,null)
        assert(hand.play(0).isValid)// right now will play the first card in the hand regardless,
        //there are rules that govern play that would change which card is played.
      }
      it ("has the number of cards equal to 13-(the round number)"){
        val hand=new Hand(null,null)
        val sim=new SimControll
        var count=0
        val roundNumber=sim.round
        val nullCard=new Card(-1,null)
        for (card <-hand.cardArray){
          if (card!=nullCard) count+=1
        }
        assert (roundNumber==(13-count))
      }
      it ("does not contain cards that were just played"){
        val hand=new Hand(null,null)
        val test=hand.play(0)
        assert(hand.cardArray(0)!=test)
      }
    }
    }
//Deleted the discard pile because it can be logically worked around.
  
  describe("the Table"){
    it("has 4 players"){fail}
    it("has 4 decks"){fail}
    it ("has 4 discard piles"){fail}
    it("has a play area"){fail}
  }
  describe("a Card"){
    it("has a rank and a valid suit"){
      val card=new Card(-1, null)
      assert (card.isValid)
    }
  }
  describe("the play area"){//must have an array and a point value associated with it, lead suit?
    it("determines the index of the highest ranking card"){
      val play= new PlayArea(0,null)
      var best= 0
      for (index<-0 until play.cards.length){
        if (play.cards(index).suit==play.lead){
          if (play.cards(index).rank>best) best=index
        }
      }
      assert(best==play.max)
    }
    it("ensures all cards are valid"){
      val play= new PlayArea(0,null)
      var flag=true
      for (card<-play.cards){
        if (!card.isValid) flag=false
      }
      assert(flag)
    }
    it("Tracks the points acquired in the pot"){
      val play= new PlayArea(0,null)
      assert (play.score>=0)
    }
  }
  describe("a Scoreboard"){
    it("carries scores over between rounds"){fail}
    it("carries scores over between hands"){fail}
    it("initializes at zero"){fail}
  }
  describe("turn queue"){
    it("analyzes each player's hand for who has the 2 of clubs at the beginning of the game"){fail}
    it("tracks which player took the pile in the previous round"){fail}
    it("calculates player order based on who took the pile last/who has the 2 of clubs"){fail}
    it("determines which player is to the left of a given player"){fail}
    it("determines which player is to the right of a given player"){fail}
    it("determines which player is across from a given player"){fail}
  }
  describe("the Mover"){
    it("tracks whose turn it is"){fail}
    it("determines when a player's turn is complete"){fail}
    it("advances the player order"){fail}
    it("tracks when the round is complete"){fail}
    it("gives the pile to the appropriate player"){fail}
  }
  describe("Background processes"){
    it("initializes the game"){fail}
    it("checks for a winner following every hand"){fail}
    
  }
}
