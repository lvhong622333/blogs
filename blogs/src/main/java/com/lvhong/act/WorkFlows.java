package com.lvhong.act;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.activiti.engine.HistoryService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.history.HistoricTaskInstance;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.lvhong.pojo.TaskInfo;

@Controller
@RequestMapping("workflows")
public class WorkFlows {
	
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	@Resource(name="runtimeService")
	private RuntimeService runtimeService;
	
	@Resource(name="taskService")
	private TaskService taskService;
	
	@Resource(name="repositoryService")
	private RepositoryService repositoryService;
	
	@Resource(name="historyService")
	private HistoryService historyService;
	
	/**
	 * 启动流程
	 * @param msg
	 * @return
	 */
	@RequestMapping("/startTask")
	@ResponseBody
	public String startTask(@RequestParam("msg") String msg) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("buyerIds","lvhong");
		String promptMessage = null;
		try {			
			ProcessInstance startProcessInstanceByKey = runtimeService.startProcessInstanceByKey("myProcess", map);
			promptMessage = "流程启动成功，流程实例id:" + startProcessInstanceByKey.getProcessInstanceId();
		}catch(Exception e) {
			promptMessage = "流程启动失败，失败异常:" + e.getMessage();
		}
		return promptMessage;
	}
	
	/**
	 * 查看当前待执行任务
	 * @return
	 */
	@RequestMapping("/findTaskList")
	@ResponseBody
	public List<TaskInfo> findTaskList() {
		//获取当前个人任务
		List<Task> list = taskService.createTaskQuery().taskAssignee("lvhong").orderByTaskCreateTime().desc().list();
		List<TaskInfo> taskInfos = new ArrayList<TaskInfo>();
		for (Task task : list) {
			TaskInfo taskinfo =new TaskInfo();
			taskinfo.setOwner(task.getAssignee());
			taskinfo.setCreateTime(sdf.format(task.getCreateTime()));
			taskinfo.setTaskName(task.getName());
			taskInfos.add(taskinfo);
		}
		return taskInfos;
	}
	
	/**
	 * 获取历史任务记录
	 * @return
	 */
	@RequestMapping("/findHistoryTaskList")
	@ResponseBody
	public List<TaskInfo> findHistoryTaskList(){
		List<HistoricTaskInstance> list = historyService.createHistoricTaskInstanceQuery().taskAssignee("lvhong").orderByTaskDueDate().desc().list();
		List<TaskInfo> taskInfos = new ArrayList<TaskInfo>();
		for (HistoricTaskInstance task : list) {
			TaskInfo taskinfo =new TaskInfo();
			taskinfo.setOwner(task.getAssignee());
			taskinfo.setCreateTime(sdf.format(task.getStartTime()));
			taskinfo.setTaskName(task.getName());
			taskInfos.add(taskinfo);
		}
		return taskInfos;
	}
	
}
