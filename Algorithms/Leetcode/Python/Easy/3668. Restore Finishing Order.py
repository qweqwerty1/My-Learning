class Solution:
    def recoverOrder(self, order, friends):
        friends_set = set(friends)
        result = []
        for i in order:
            if i in friends_set:
                result.append(i)
        return result

def main():
    order = map(int,input("order input : ").strip().split())
    friends = map(int,input("friends input : ").strip().split())
    print(Solution().recoverOrder(order,friends))

if __name__ == "__main__":
    main()