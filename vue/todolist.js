var todo = new Vue({
	el: '#todo',
	data: {
		addText: '',
		curIndex: '',
		beforeEditText: '',
		//name-名称,status-完成状态
		todoList: [
			{name:'学习HTML5', status:false},
			{name:'学习CSS3', status:false},
			{name:'学习JS', status:false},
			{name:'学习Vue', status:false},
			{name:'学习React', status:false},
		],
		// 存储
		newTodoList:[]
	},

	methods: {
		addList() {
			if(this.addText != "") {
				this.todoList.push({
					name: this.addText,
					status: false,
				});
				this.addText="";
			}
			else{
				alert("输入不能为空，请重新输入！");
			}
		},

		// 所有、已完成、未完成清单
		chooseList(type) {
			switch(type) {
				case 1: this.newTodoList = this.todoList;break;
				case 2: this.newTodoList = this.todoList.filter(function(item) {return item.status});break;
				case 3: this.newTodoList = this.todoList.filter(function(item) {return !item.status});break;

			}
		},

		// 切换状态
		cutState() {


		},

		// 删除
		delect(index) {
			this.todoList.splice(index, 1);
			this.newTodoList = this.todoList;
		},

		// 取消修改
		cancelEdit(val) {
			val.name=this.beforeEditText;
			this.curIndex="";
		},

		// 修改后
		editAfter() {
			this.curIndex="";


		},

		// 修改前
		editBefore(name) {
			this.beforeEditText=name;
		},

	},

	computed: {
		// 未完成的待办
		noend: function() {
			return this.todoList.filter(function(item) {
				return !item.status
			}).length;
		}
	},

	// 自定义事件
	directives: {
		// 自动获取焦点
		"focus": {
			update(el) {
				el.focus();
			}
		}
	},

	// 初始化
	mounted() {
		this.newTodoList = this.todoList;
	},
})