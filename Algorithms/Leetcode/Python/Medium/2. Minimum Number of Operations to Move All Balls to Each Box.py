class Solution:
    def minOperations(self, boxes):
        n = len(boxes)
        result = []
        for i in range(n):
            x = 0
            for j in range(n):
                if i == j:
                    continue
                
                if boxes[j] == "1":
                    x += abs(i - j)
            result.append(x)
        
        return result
        
def main():
    boxes = "001011"
    sol = Solution()
    print(sol.minOperations(boxes))

if __name__ == "__main__":
    main()