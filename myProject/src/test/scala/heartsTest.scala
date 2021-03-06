package myProject

import org.scalatest.FunSpec
import org.scalatest.Matchers



class heartsTest extends FunSpec with Matchers{

  describe ("a Deck"){
    describe("before a hand"){
      it("has 52 cards"){
      val deck= new Deck
      assert (deck.length==52)  
      }
      
      it("has no repeated elements"){
        val deck= new Deck
        var mover=Set[model.Card]()
        while (!deck.isEmpty) mover+=deck.deal
        assert (mover.size==52)
        }
      
      it("is shuffled"){
        val deck = new model.Deck
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
   
    describe("at the start of a hand"){
      it ("has 13 cards"){
        val hand=new Hand(0)
        assert (hand.cardSet.size==13)
      }

    }
    

      it ("has the number of cards equal to 13-(the round number)"){
        val hand=new Hand(0)
        val sim=new SimControll
        val roundNumber=sim.round
        assert (roundNumber==(13-hand.cardSet.size))
      }
      it ("does not contain cards that were just played"){
        val hand=new Hand(0)
        val playArea=new PlayArea
        val test=hand.play("Heart")
        playArea.assignCard(hand.seat,test)
        assert(!hand.cardSet.contains(playArea.cards(hand.seat)))
      }
    }
//Deleted the discard pile because it can be logically worked around.
  

  describe("a Card"){
    it("has a rank and a valid suit"){
      val card=new Card(-1, null)
      assert (card.isValid)
    }
  }
  describe("the play area"){//must have an array and a point value associated with it, lead suit?
    it("determines the index of the highest ranking card"){
      val play= new PlayArea
      var best= 0
      for (index<-0 until play.cards.length){
        if (play.cards(index).suit==play.lead){
          if (play.cards(index).rank>best) best=index
        }
      }
      assert(best==play.max)
    }
    it("ensures all cards are valid"){
      val play= new PlayArea
      var flag=true
      for (card<-play.cards){
        if (!card.isValid) flag=false
      }
      assert(flag)
    }
    it("Tracks the points acquired in the pot"){
      val play= new PlayArea
      assert (play.calculateScore>=0)
    }
  }
  describe("a Scoreboard"){
    it("checks for a loser"){
      val score =new Scoreboard
      score.loserCheck should be (false)
      score.scores(0)=100
      score.loserCheck should be (true)
    }
    it("initializes at zero"){
      val score =new Scoreboard
      for (item<-score.scores) item should be (0)
    }
  }
  describe("turn queue"){
    it("analyzes each player's hand for who has the 2 of clubs at the beginning of the game"){fail}
    it("tracks which player took the pile in the previous round"){
      val sim=new SimControll
      sim.hand1.cardSet.apply(sim.twoClub)
      sim.loadQueue
      sim.queue.dequeue should be (0)
      
    }
    it("calculates player order based on who took the pile last/who has the 2 of clubs"){
      val test=new TurnQueue
      test.load(0)
      test.dequeue should be (0)
      test.dequeue should be (1)
      test.dequeue should be (2)
      test.dequeue should be (3)
      test.load (1)
      test.dequeue should be (1)
      test.dequeue should be (2)
      test.dequeue should be (3)
      test.dequeue should be (0)
      test.load(2)
      test.dequeue should be (2)
      test.dequeue should be (3)
      test.dequeue should be (0)
      test.dequeue should be (1)
    }
    it("determines which player is to the left of a given player"){fail}
    it("determines which player is to the right of a given player"){fail}
    it("determines which player is across from a given player"){fail}
    //bottom three test cases can be solved mathmatically, and are not important for version 1.1
  }
  describe("the Mover"){
    it("advances the player order"){fail}
    it("tracks when the round is complete"){fail}
    it("gives the pile to the appropriate player"){fail}
  }
  describe("Background processes"){
    it("initializes the game"){fail}
    it("checks for a winner following every hand"){fail}
    
  }
}

