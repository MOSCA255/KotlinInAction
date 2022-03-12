package kotlininaction.episode2

class Person(
    val personName : String, // 읽기 전용 프로퍼티, 비공개 필드와 공개 getter 를 만든다.
    var isMarried : Boolean //쓸 수 있는 프로퍼티로 비공개필드, 공개 g/s 를 만든다.
)