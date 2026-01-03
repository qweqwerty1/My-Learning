class Solution:
    def findMaxConsecutiveOnes(self, nums):
        
        # 1. 님이 제안한 천재적인 '엣지 케이스' 전처리
        if 0 not in nums:
            return len(nums)
        
        # 2. 0이 하나라도 있음을 보장받았으니, 
        #    '0 기준 앞뒤 더하기' 로직을 안심하고 실행
        max_len = 0
        prev_count = 0
        curr_count = 0
        
        for n in nums:
            if n == 1:
                curr_count += 1
            else:
                # 0을 만났을 때, "직전 묶음 + 현재 묶음 + 1(0)"을 계산
                max_len = max(max_len, prev_count + curr_count + 1)
                
                # '현재 묶음'을 '직전 묶음'으로 넘기고 리셋
                prev_count = curr_count
                curr_count = 0
        
        # 3. 마지막 묶음 처리 (예: [1,0,1,1])
        #    루프가 끝나도 prev=1, curr=2가 남아있음
        max_len = max(max_len, prev_count + curr_count + 1)
        
        return max_len
        
def main():
    nums = [1,1,0,1,1,1,0,1,1,1,1,1,0,1,1]
    sol = Solution()
    print(sol.findMaxConsecutiveOnes(nums))
    return 0

if __name__ == "__main__":
    main()