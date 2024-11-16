def dance_revolution(n, instructions):
    directions = {"up": 0, "down": 1, "left": 2, "right": 3}
    moves = [directions[inst] for inst in instructions]
    
    inf = float('inf')
    dp = [[[inf] * 4 for _ in range(4)] for _ in range(n + 1)]
    
    for j in range(4):
        for k in range(4):
            if j != k:
                dp[0][j][k] = 0
    
    for i in range(1, n + 1):
        target = moves[i - 1] 
        for j in range(4):
            for k in range(4):
                if j != k:
                    dp[i][target][k] = min(dp[i][target][k], dp[i - 1][j][k] + (j != target))
                    dp[i][j][target] = min(dp[i][j][target], dp[i - 1][j][k] + (k != target))
    
    min_moves = inf
    for j in range(4):
        for k in range(4):
            if j != k:
                min_moves = min(min_moves, dp[n][j][k])
    
    return min_moves

n = int(input())
instructions = [input().strip() for _ in range(n)]

print(dance_revolution(n, instructions))
