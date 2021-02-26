/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/** 88
 * @param {TreeNode} root
 * @return {string[]}
 */
var binaryTreePaths = function(root) {
    const paths = [];
    const construct_paths = (root, path) => {
        if(root) {
            path += root.val.toString();
            if(root.left === null && root.right === null) { // 当前节点是叶子节点
                paths.push(path); // 把路径加入到答案中
            } else {
                path += "->"; // 当前节点不是叶子节点，继续递归遍历
                construct_paths(root.left, path);
                construct_paths(root.right, path);
            }
        }
    }
    construct_paths(root, "");
    return paths;
};
/** 76
 * @param {TreeNode} root
 * @return {string[]}
 */
var binaryTreePaths = function(root) {
    if(!root) {
        return [];
    }
    if(!root.left && !root.right) {
        return [root.val.toString()]
    }
    let leftPaths = binaryTreePaths(root.left);
    let rightPaths = binaryTreePaths(root.right);
    return leftPaths.concat(rightPaths).map(item => root.val + '->' + item)
};

