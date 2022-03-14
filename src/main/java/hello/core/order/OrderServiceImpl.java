package hello.core.order;

import hello.core.annotation.MainDiscountPolicy;
import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
//@RequiredArgsConstructor  //lombok을 이용하여 생성자를 생략시켜줌
public class OrderServiceImpl implements OrderService{

    /**
     * 의존관계주입 중 자동주입
     * 1. 생성자주입 2. 수정자주입 3.필드주입, 4.메소드주입 (4가지)
     *
     * Autowired주입 방법중 생성자 주입방법을 이용하라.
     * 불변
     *  - 대부분의 의존관계 주입은 애플리케이션 실행에서부터 종료시까지 의존관계를 변경할일이 없음
     *    그래서 애플리케이션 종료시까지 불변해야함
     *  - 수정자 주입의 경우에는 setXXX등의 메소드를  public으로 열어두어야 하기때문에
     *    개발자가 실수로라도 불변의 경우에서 변경을 할 수 있는 환경이 되기때문에 문제가 될 수 있음.
     *
     * 누락
     *  - 프레임워크 없이 순수한 자바 코드를 단위 테스트 하는 경우
     */
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member,itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    //테스트용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
