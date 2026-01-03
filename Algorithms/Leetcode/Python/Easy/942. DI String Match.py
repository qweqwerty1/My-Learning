from collections import deque

class Solution:
    def diStringMatch(self, s):
        que = deque(i for i in range(len(s) + 1))
        result = []

        for i in s:
            if i == "I":
                result.append(que.popleft())
            else:
                result.append(que.pop())
        
        result.append(que.pop())

        return result

def main():
    s = "DDDDIIII"
    sol = Solution()
    print(sol.diStringMatch(s))

if __name__ == "__main__":
    main()