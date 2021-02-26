var removeElements = function (head, val) {
    let sentinel = new ListNode();//哑节点
    sentinel.next = head;
    let now = sentinel;
    while (now.next) {
        if (now.next.val == val) {
            now.next = now.next.next;
        } else {
            now = now.next;
        }
    }
    return sentinel.next;
};