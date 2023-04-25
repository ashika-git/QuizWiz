package com.ashika.myquizapp

object Constants {

    const val USER_NAME : String = "user_name"
    const val CORRECT_ANS:String ="correct_ans"
    const val TOTAL_QUESTION:String ="total_ans"

    fun getQuestions():ArrayList<Question>{
        val questionList = ArrayList<Question>()

        val que1 = Question(
            1 ,"What country does this flag belong to?" ,
            R.drawable.ic_flag_of_argentina,
            "Argentina","Australia",
            "Armenia" ,"Austria",
        1
        )
        questionList.add(que1)

        val que2 = Question(
            2 ,"What sign it is?" ,
            R.drawable.img_2,
            "No Left sign","U turn sign",
            "No U turn sign" ,"No right sign",
            3
        )
        questionList.add(que2)

        val que3 = Question(
            3 , "Simplify the following expression :- 3 + 5 * 2 - 6 / 3",
             R.drawable.img_8,"12" , "15" , "11", "20" ,
            3
        )
        questionList.add(que3)

        val que4 = Question(
            4,"Tom has 12 apples. He gives 3 apples to his friend and then buys 5 more apples." +
                    " How many apples does he have now?" , R.drawable.img_3,
            "10","26","44","14" , 4
        )
        questionList.add(que4)

        val que5 = Question(
            5,"Which is the largest continent in the world?", R.drawable.img_4,"Aisa","Africa",
            "North America","Europe",
            1
        )
        questionList.add(que5)

        val que6 = Question(
            6,"I am always hungry, I must always be fed. The finger I touch, will soon turn red. What am I?",
            R.drawable.img_8,"A flame","A baby",
            "A cat","A fire ",
            4
        )
        questionList.add(que6)

        val que7 = Question(
            7,"What runs but never walks, has a mouth but never talks, has a bed but never sleeps?",
            R.drawable.img_8,"A River","A Car",
            "A plant","A Computer ",
            1
        )
        questionList.add(que7)

        val que8 = Question(
            8,"Why do elephants never use computers ?",
            R.drawable.img_7,"Because they're afraid of mice.","Because they don't have it",
            "Because they dont want to use it","Ask elephants", 1

        )
        questionList.add(que7)

        val que9 = Question(
            9,"Why was the math book sad?",
            R.drawable.img_6,"Because it was always being multiplied","Because it was always being multiplied",
            "Because it was full of numbers","Because it had too many problems",
            4
        )
        questionList.add(que9)
        val que10 = Question(
            10, "Which country gifted the Statue of Liberty to the United States?",
                    R.drawable.img_5,"France","India","Australia" ,"Korea" ,
            1
        )
        questionList.add(que10)
















        return questionList
    }
}
//3 + 5 * 2 - 6 / 3