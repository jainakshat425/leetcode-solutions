/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer,Employee> empMap = new HashMap();
        
        for(Employee emp : employees)
            empMap.put(emp.id, emp);
        
        return dfs(empMap.get(id), empMap);
    }
    
    private int dfs(Employee curEmp, Map<Integer,Employee> empMap) {
        int ans = curEmp.importance;
        
        for(Integer empId : curEmp.subordinates)
            ans += dfs(empMap.get(empId), empMap);
        
        return ans;
    }
}
