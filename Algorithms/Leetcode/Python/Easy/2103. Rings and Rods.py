class Solution:
    def countPoints(self, rings):
        result = [set() for _ in range(10)]
        
        for i in range(0, len(rings), 2):
            color = rings[i]
            idx = int(rings[i+1])
            result[idx].add(color)

        return sum(1 for i in result if {"R","G","B"}.issubset(i))
    
def main():
    rings = "G4R4B4G2R2B2"
    sol = Solution()
    print(sol.countPoints(rings))

if __name__ == "__main__":
    main()