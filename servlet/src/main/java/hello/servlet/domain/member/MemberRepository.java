package hello.servlet.domain.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemberRepository {

    private Map<Long, Member> storage = new HashMap<>();
    private Long sequence = 0L;

    private static final MemberRepository instance = new MemberRepository();

    private MemberRepository() {}

    public static MemberRepository getInstance() {
        return instance;
    }

    public Member save(Member member) {
        member.setId(++sequence);
        storage.put(member.getId(), member);
        return member;
    }

    public Member findById(Long id) {
        return storage.get(id);
    }

    public List<Member> findAll() {
        return new ArrayList<>(storage.values());
    }

    public void clearStore() {
        storage.clear();
    }

}
