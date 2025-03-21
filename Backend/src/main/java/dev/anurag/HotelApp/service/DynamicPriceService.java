package dev.anurag.HotelApp.service;


import org.springframework.stereotype.Service;

@Service
public class DynamicPriceService {

    private int[] segmentTree;
    private int n;

    public void initialize(int[] demand) {
        n = demand.length;
        segmentTree = new int[4 * n];
        buildSegmentTree(demand, 0, 0, n - 1);
    }

    private void buildSegmentTree(int[] demand, int node, int start, int end) {
        if (start == end) {
            segmentTree[node] = demand[start];
        } else {
            int mid = (start + end) / 2;
            buildSegmentTree(demand, 2 * node + 1, start, mid);
            buildSegmentTree(demand, 2 * node + 2, mid + 1, end);
            segmentTree[node] = segmentTree[2 * node + 1] + segmentTree[2 * node + 2];
        }
    }

    public int getTotalDemand(int left, int right) {
        return query(0, 0, n - 1, left, right);
    }

    private int query(int node, int start, int end, int left, int right) {
        if (right < start || left > end) return 0;
        if (left <= start && right >= end) return segmentTree[node];

        int mid = (start + end) / 2;
        return query(2 * node + 1, start, mid, left, right) +
                query(2 * node + 2, mid + 1, end, left, right);
    }

    public double calculatePrice(double basePrice, int demandFactor) {
        return basePrice + (demandFactor * 0.1 * basePrice);
    }
}
