import heapq;

class Solution:
    # INF=float('-inf')
    def maxDistance(self, V, src, edges):
        adj=[[] for _ in range(V)]
        indegree=[0]*V;
    
        for u, v, wt in edges:
            adj[u].append((v, wt))
            indegree[v]+=1
        
        pq=[]
        for i in range(V):
            if indegree[i] == 0:
                heapq.heappush(pq, i)
                
        
        dist=[float('-inf')]*V
        dist[src]=0
        
        while pq:
            node=heapq.heappop(pq)
            
            for nxt, wt in adj[node]:
                if dist[node] != float('-inf'):
                    dist[nxt]=max(dist[nxt], dist[node]+wt)
            
                
                indegree[nxt]-=1
                if indegree[nxt] == 0:
                    heapq.heappush(pq, nxt)
                
                
        # INF = 10**18
        for i in range(V):
            if dist[i] == float('-inf'):
                dist[i] = 'INF'
        
        return dist
        
 

