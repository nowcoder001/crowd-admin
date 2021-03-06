<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<meta charset="utf-8">
<%@ include file="/commom/taglib.jsp"%>
<%@ include file="/commom/header.jsp"%>
<body class="gray-bg">
	<div class="wrapper wrapper-content animated fadeInRight">
		<div class="row">
			<div class="col-sm-12">
                <div class="tree-search-content">
                    <label for="keyword">关键字：</label><input type="text" class="empty" id="keyword" maxlength="50">
					<button class="btn  btn-xs" onclick="search()">搜索</button>
				</div>
				<div class="ibox-content">
                    <div id="menuTree"></div>
				</div>
				<div class="form-group hidden">
					<div class="col-sm-12 col-sm-offset-12">
						<button type="submit" class="btn btn-primary">提交</button>
					</div>
				</div>
			</div>
		</div>
	</div>
	<%@ include file="/commom/footer.jsp"%>
	<script>
		var prefix = _ctx + '/system/menu';
		
		function search(){
			$('#menuTree').jstree(true).search($('#keyword').val())
		}
		
		function getTreeData() {
			$.ajax({
				type : "POST",
                dataType :'json',
				url : prefix + "/tree",
				success : function(tree) {
					loadTree(tree);
				}
			});
		}
		function loadTree(tree) {
			$('#menuTree').jstree({
				'core' : {
					'data' : tree,
					'themes' : {
						'name' : "proton"
					}
				},
				"plugins" : [ "search" ]
			});
		}

		$("#menuTree").on("loaded.jstree", function(event, data) {
			// 展开所有节点
			//$('#menuTree').jstree(true).open_all();
		});

		$('#menuTree').on("changed.jstree", function(e, data) {
			if (data.node.id == '-1') {
				parent.loadMenu(0, '顶级节点');
			} else {
				parent.loadMenu(data.node.id, data.node.text);
			}
			var index = parent.layer.getFrameIndex(window.name); // 获取窗口索引
			parent.layer.close(index);
		});

		$(function() {
			getTreeData();
		})
	</script>
</body>

</html>
