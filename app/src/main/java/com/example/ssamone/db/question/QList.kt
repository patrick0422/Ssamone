package com.example.ssamone.db.question

class QList {
    companion object {
        val qList = listOf(
                "오늘이 당신의 마지막 날이라면 어떤 하루를 보내고 싶나요?",
                "당신은 어떤 맛의 아이스크림을 좋아하시나요?",
                "당신이 가장 당신다워지는 순간은 언제인가요?",
                "당신이 가장 먼저 떠오르는 노래는 무엇인가요?",
                "나만의 밥도둑!, 난 반찬 '이것'만 있으면 밥 두공기는 넘게 먹을 수 있다.",
                "당신에게 가장 감명 깊었던 영화는 무엇인가요?",
                "당신은 여가시간에 무엇을 하며 보내나요?",
                "당신에게 가장 감명 깊었던 책은 무엇인가요?",
                "당신이 가장 좋아하는 음악은 무엇인가요?",
                "당신이 어떤 사람인지 소개해주세요!, 별게아니더라도 좋아요!",
                "10만원을 가장 알차게 쓸 수 있는 방법은 무엇일까요??",
                "당신에게 혼밥하기 가장 좋은 곳과 그 이유는 무엇인가요?",
                "당신이 가장 바보 같았던 순간은 언제인가요?",
                "부모님께 가장 죄송했던 순간은 언제인가요?",
                "남들은 모르는 자신만의 비밀은?",
                "당신이 가장 이루고싶은 것은 무엇인가요?",
                "늦은 시각, 집에 혼자있는데 누군가 들어오는 인기척이 느껴진다면!?",
                "'나'라는 사람에 대해서 다른사람들이 오해하고 있는 것은 무엇인가요?",
                "사람과 교류를 하는것에 있어, 자신만의 선은??",
                "만약 초능력을 가지게 된다면, 어떤 능력을 가지고 싶나요?",
                "당신은 가족에게 어떤 의미인가요?",
                "당신이 가장 좋아하는 쌈채소는 무엇인가요?",
                "당신은 행복을 위해 얼마만큼의 돈이 필요하다고 생각하시나요?",
                "만들어보고싶은 것이 있다면 그건 무엇을 위한것인가요?",
                "키워보고싶은 동물이 있나요?, 그 이유도 말해주세요!",
                "당신은 미래에, 어떤 모습으로 어떻게 살아가고싶으신가요?",
                "갑자기 일 년간 여행을 떠나게 된다면, 어디로 떠나고싶으신가요?",
                "당신의 요즘 상태를 한줄로 적어본다면?",
                "요즘 즐거운 일들을 나열해 보세요!",
                "당신에게 가장 어울리는 색을 고르자면?",
                "당신의 감정을 이모티콘으로 나타내자면 어떤 모습인가요?",
                "당신이 가장 신경써서 하는 자기관리는!?",
                "당신이 살면서 가장 힘들었던 적은 언제인가요?",
                "당신에게 다가왔던 인연에게 가장 미안했던 적은 언제인가요?",
                "인생의 방향을 정할 때 가장 중요한 것은 무엇일까요?",
                "부모님에게 요리를 대접드리게 됐을 때, 당신은 어떤 요리를 하고싶으신가요?",
                "당신이 가장 좋아하는 제철 음식은 무엇인가요?",
                "요즘 당신을 행복하게 만드는 요소는!?",
                "친구가 당신에게 보증을 서달라고 한다면!?",
                "당신을 대할 때, 어떤 점들을 지켜줬으면 좋겠나요?",
                "자신의 이름으로 삼행시!",
                "당신이 절대 버릴 수 없는 것은 무엇인가요?",
                "당신이 올해 새롭게 깨닫게 된 것에 대해 말씀해주세요",
                "괜찮아! 라고 자신있게 말했지만, 하나도 괜찮지 않았던 적은?",
                "당신의 마음을 편하게 만들어주는 장소는 어디인가요?",
                "자신이 역사책에 실린다면, 어떤식으로 실리고 싶으시간요?",
                "올해 연말은 어떻게 보내고 싶은가요?",
                "당신에게 가장 중요하지않은 것은 무엇인가요?(쓰레기 제외!)",
                "내일의 당신에게 미션 주기!, 꼭 지켜주세요!!",
                "당신의 성별이 바뀐다면, 무엇부터 하고싶으신가요?"
        )

        fun getQList(): ArrayList<Question> {
            var qlist = ArrayList<Question>()

            for(num in qList.indices) {
                qlist.add(Question(num + 1, qList[num], "", ""))
            }

            return qlist
        }
    }
}