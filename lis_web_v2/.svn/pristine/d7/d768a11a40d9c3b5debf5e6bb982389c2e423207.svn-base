package com.cdxt.lisweb.utils;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Date;
import java.util.Deque;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.cdxt.lisweb.entity.barcode.LisWebBarcodeRule;
import com.cdxt.lisweb.entity.barcode.LisWebBcruleContainer;
import com.cdxt.lisweb.entity.barcode.LisWebBcruleItem;
import com.cdxt.lisweb.entity.barcode.LisWebBcruleSingleitem;
import com.cdxt.lisweb.exception.BarCodeRuleContainerNotSetException;
import com.cdxt.lisweb.exception.BarCodeRuleNotFoundException;
import com.cdxt.lisweb.model.barcode.Rule;
import com.cdxt.lisweb.model.barcode.Rule.Type;

/**
 * <p>
 * 根据检验申请项目匹配条码规则; {@link #matchRules(Set)}
 * </p>
 * 生成条码号和条码号与项目的关系 {@link #createBarCode(Rule, Map)}
 * 
 * @author zhaozeyu
 * @date 2018年2月28日 15:08:23
 * @since 1.0.0
 */
public class BarCodeRuleMatcher {

	private Set<Rule> urules = null;

	/**
	 * 规则过滤集合
	 */
	private final Deque<BarCodeRuleFilter> filters = new ArrayDeque<BarCodeRuleFilter>();

	private BarCodeRuleMatcher() {
		/*filters.add(new ConditionFilter());// 适合条件
		filters.add(new ItemsFilter());// 规则项目是否在申请项目中全部能找到
		// filters.add(new ItemsCountFilter());// 挑选匹配的项目数量最多的规则
		filters.add(new PriorityFilter());// 挑选优先级最大的规则
		filters.add(new SingleItemFilter());// 未匹配到的采用单项目规则
*/	}

	private BarCodeRuleMatcher(Set<LisWebBarcodeRule> rules, List<LisWebBcruleSingleitem> itemRules) {
		this();
		setRules(rules, itemRules);
	}

	public static BarCodeRuleMatcher newInstance() {
		return new BarCodeRuleMatcher();
	}

	public static BarCodeRuleMatcher getInstance(Set<LisWebBarcodeRule> rules, List<LisWebBcruleSingleitem> itemRules) {
		return new BarCodeRuleMatcher(rules, itemRules);
	}

	/**
	 * 添加所有规则
	 * 
	 * @param rules
	 * @param itemRules
	 */
	public BarCodeRuleMatcher setRules(Set<LisWebBarcodeRule> rules, List<LisWebBcruleSingleitem> itemRules) {
		urules = new LinkedHashSet<Rule>();
		for (LisWebBarcodeRule rule : rules) {
			rule.setRuleType(Type.MERGE);
			urules.add(rule);
		}
		for (LisWebBcruleSingleitem rule : itemRules) {
			rule.setRuleType(Type.SINGLE);
			urules.add(rule);
		}
		return this;
	}

	/**
	 * 匹配申请项目的条码生成规则
	 * 
	 * @param items
	 *            检验申请项目
	 * @return 匹配到的条码规则（包括合并规则和单项目规则）
	 * @throws BarCodeRuleNotFoundException
	 */
	public Set<Rule> matchRules(List<String> items) throws BarCodeRuleNotFoundException {
	/*	for (BarCodeRuleFilter filter : filters) {
			urules = filter.doFilter(items);
			System.out.println(urules.toString());
		}
		if (items.size() > 0) {// 如果还有项目没有匹配到规则
			throw new BarCodeRuleNotFoundException(items.toString());
		}
		return urules;*/
		return null;
	}

	/**
	 * 
	 * @author lixying
	 * @date 2017年5月16日 下午1:53:49
	 * @since 1.0.0
	 */
	public static interface BarCodeRuleFilter {
		/**
		 * 执行过滤操作
		 * 
		 * @param items
		 * @return
		 */
		/*public Set<Rule> doFilter(Set<LisReqOrderNo> items);*/

	}

	/**
	 * 适合条件过滤
	 * 
	 * @author lixying
	 * @date 2017年5月16日 下午1:53:32
	 * @since 1.0.0
	 */
/*	private class ConditionFilter implements BarCodeRuleFilter {

		private final Type t = Type.MERGE;

		@Override
		public Set<Rule> doFilter(Set<LisReqOrderNo> items) {
			if (urules == null) {
				throw new IllegalStateException("规则尚未设置");
			}
			Set<Rule> rst = new HashSet<Rule>();

			for (Rule rule : urules) {
				if (rule.getRuleType() == t) {
					LisWebBarcodeRule r = (LisWebBarcodeRule) rule;
					if (!StringUtils.hasText(r.getCondition())) {
						rst.add(rule);
					} else {
						// TODO 根据设置的条件过滤;
					}
				} else {
					rst.add(rule);
				}
			}
			return rst;
		}

	}*/

	/**
	 * 规则的项目过滤
	 * 
	 * @author lixying
	 * @date 2017年5月16日 下午2:00:38
	 * @since 1.0.0
	 */
/*	private class ItemsFilter implements BarCodeRuleFilter {
		private final Type t = Type.MERGE;

		private List<LisReqOrderNo> need = new ArrayList<LisReqOrderNo>();

		@Override
		public Set<Rule> doFilter(Set<LisReqOrderNo> items) {
			if (urules == null) {
				throw new IllegalStateException("规则尚未设置");
			}

			Set<Rule> rst = new HashSet<Rule>();

			for (Rule rule : urules) {
				need.clear();
				if (rule.getRuleType() == t) {
					LisWebBarcodeRule r = (LisWebBarcodeRule) rule;
					Set<LisInspItemManage> ruleItems = r.getImList();

					for (LisReqOrderNo item : items) {
						if (find(item, ruleItems)) {
							need.add(item);
						}
					}
					if (need.size() == ruleItems.size()) {// 说明规则中的所有项目在申请项目中都找到了,更进一步可以将两边的项目编码排序，串联起来做比较
						rst.add(rule);
					}
				} else {
					rst.add(rule);
				}
			}
			return rst;
		}

	}*/

	/**
	 * 规则的项目个数最大过滤
	 * 
	 * @Deprecated 如果最大项目个数和其他规则的项目有交叉才需要此过过滤
	 * @author lixying
	 * @date 2017年5月16日 下午2:00:38
	 * @since 1.0.0
	 */
/*	@Deprecated
	class ItemsCountFilter implements BarCodeRuleFilter {
		private final Type t = Type.MERGE;

		@Override
		public Set<Rule> doFilter(Set<LisReqOrderNo> items) {
			if (urules == null) {
				throw new IllegalStateException("规则尚未设置");
			}
			Set<Rule> rst = new HashSet<Rule>();
			Set<Rule> rst2 = new HashSet<Rule>();
			int count = 0;
			for (Rule rule : urules) {
				if (rule.getRuleType() == t) {
					LisWebBarcodeRule r = (LisWebBarcodeRule) rule;
					Set<LisInspItemManage> ruleItems = r.getImList();
					if (ruleItems.size() == count) {
						rst2.add(rule);
					} else if (ruleItems.size() > count) {
						rst2.clear();
						rst2.add(rule);
						count = ruleItems.size();
					} else {

					}
				} else {
					rst.add(rule);
				}
			}
			rst.addAll(rst2);
			return rst;
		}

	}*/

	/**
	 * 规则项目数量和优先级过滤， 项目越多，优先级越大越靠前
	 * 
	 * @author lixying
	 * @date 2017年5月16日 下午2:01:37
	 * @since 1.0.0
	 */
/*	private class PriorityFilter implements BarCodeRuleFilter {
		private final Type t = Type.MERGE;

		@Override
		public Set<Rule> doFilter(Set<LisReqOrderNo> items) {
			if (urules == null) {
				throw new IllegalStateException("规则尚未设置");
			}
			Set<Rule> rst = new HashSet<Rule>();
			List<LisWebBarcodeRule> rst2 = new LinkedList<LisWebBarcodeRule>();
			for (Rule rule : urules) {
				if (rule.getRuleType() == t) {
					rst2.add((LisWebBarcodeRule) rule);
				} else {
					rst.add(rule);
				}
			}
			if (rst2.size() == 0) {
				return rst;
			}
			Collections.sort(rst2, new Comparator<LisWebBarcodeRule>() {
				@Override
				public int compare(LisWebBarcodeRule o1, LisWebBarcodeRule o2) {
					if (o1.getImList().size() > o2.getImList().size()) {
						return -1;
					} else if (o1.getImList().size() == o2.getImList().size()) {
						if (o1.getPriority() > o2.getPriority()) {
							return -1;
						} else {
							return 1;
						}
					} else {
						return 1;
					}
				}
			});

			// 项目数量最多的情况下，优先级最高的规则
			LisWebBarcodeRule rule = rst2.get(0);

			*//**
			 * 检查和第一规则有的交叉项目的规则 ，这些规则不要
			 *//*
			Set<Rule> rst3 = new HashSet<Rule>();

			for (LisInspItemManage item : rule.getImList()) {
				for (int i = 1; i < rst2.size(); i++) {
					LisWebBarcodeRule rule1 = rst2.get(i);
					boolean yes = true;
					for (LisInspItemManage item1 : rule1.getImList()) {
						if (item.getItemCode().getItemCode().equals(item1.getItemCode().getItemCode())) {
							yes = false;
							break;
						}
					}
					if (!yes) {
						rst3.add(rule1);
					}
				}
			}
			rst2.removeAll(rst3);

			// 去除交叉项目规则后剩下的所有规则都是需要的
			rst.addAll(rst2);

			return rst;
		}

	}*/

	/**
	 * 所有合并规则过滤完成，只能使用单个项目的单条规则
	 * 
	 * @author lixying
	 * @date 2017年5月16日 下午2:27:08
	 * @since 1.0.0
	 */
/*	private class SingleItemFilter implements BarCodeRuleFilter {
		private final Type t = Type.SINGLE;

		@Override
		public Set<Rule> doFilter(Set<LisReqOrderNo> items) {
			if (urules == null) {
				throw new IllegalStateException("规则尚未设置");
			}
			Set<Rule> rst = new HashSet<Rule>();
			Set<LisInspItemManage> rst2 = new HashSet<LisInspItemManage>();
			for (Rule rule : urules) {
				if (rule.getRuleType() != t) {// 去除已匹配的合并规则中的项目
					rst2.addAll(((LisWebBarcodeRule) rule).getImList());
				}
			}
			removeFind(items, rst2);
			Set<LisReqOrderNo> needRemoved = new HashSet<LisReqOrderNo>();
			for (Rule rule : urules) {
				if (rule.getRuleType() == t) {// 匹配单项目规则
					LisWebBcruleSingleitem r = (LisWebBcruleSingleitem) rule;
					for (LisReqOrderNo item : items) {
						if (r.getItemCode().getItemCode().equals(item.getItemCode())) {
							rst.add(r);
							needRemoved.add(item);
						}
					}

				} else {
					rst.add(rule);
				}
			}
			// 移除单项目规则匹配到的项目，如果还有剩下的项目，说明这些项目连单规则也没有
			items.removeAll(needRemoved);

			return rst;
		}*/

		/**
		 * 移除已在合并规则中找到匹配的项目
		 * 
		 * @param items
		 */
/*		private void removeFind(Set<LisReqOrderNo> items, Set<LisInspItemManage> rst2) {
			Set<LisReqOrderNo> needRemoved = new HashSet<LisReqOrderNo>();

			for (LisReqOrderNo item : items) {
				if (find(item, rst2)) {
					needRemoved.add(item);
				}
			}

			items.removeAll(needRemoved);
		}

	}*/

/*	private static boolean find(LisReqOrderNo applyItem, Set<LisInspItemManage> ruleItems) {
		for (LisInspItemManage item : ruleItems) {
			if (item.getItemCode().getItemCode().equals(applyItem.getItemCode())) {
				return true;
			}
		}
		return false;

	}*/

	/**
	 * 根据规则生成随机条码号
	 * 
	 * @param rule
	 *            条码规则
	 * @param items
	 *            生成 条码号和项目编码的对应关系
	 * @return 条码号
	 * @throws BarCodeRuleContainerNotSetException
	 */
	public List<String> createBarCode(Rule rule, Map<String, List<String>> items)
			throws BarCodeRuleContainerNotSetException {
		List<String> rst = new ArrayList<String>();
		switch (rule.getRuleType()) {
		case MERGE:
			LisWebBarcodeRule insRule = (LisWebBarcodeRule) rule;
			List<String> ics = new ArrayList<String>();
			for (LisWebBcruleItem im : insRule.getLisWebBcruleItems()) {
				ics.add(im.getLisRequestionItem().getId());
			}

			List<LisWebBcruleContainer> cs = insRule.getLisWebBcruleContainers();
			if (cs.size() == 0) {
				throw new BarCodeRuleContainerNotSetException(insRule.getRuleName());
			}
			for (LisWebBcruleContainer c : cs) {
				for (int i = 0; i < Integer.valueOf(c.getUseNumber()); i++) {
					String barCode = genernate(c.getId().hashCode() + i);
					rst.add(barCode);
					items.put(barCode, ics);
				}
			}

			break;

		case SINGLE:
			final LisWebBcruleSingleitem itemRule = (LisWebBcruleSingleitem) rule;
			for (int i = 0; i < itemRule.getUseNumber().intValue(); i++) {
				String barCode = genernate(itemRule.getId().hashCode() + i);
				rst.add(barCode);
				items.put(barCode, new ArrayList<String>() {
					/**
					 * 
					 */
					private static final long serialVersionUID = -7783132091929448003L;

					{
						add(itemRule.getLisRequestionItem().getId());
					}
				});
			}
			break;
		}

		return rst;
	}

	private Format format = new SimpleDateFormat("yyMMddHHmmss");
	private int oriSeed = 0;

	private String genernate(int seed) {
		String time = format.format(new Date());
		long x = Long.parseLong(time);
		return String.valueOf(seed + x + oriSeed++);
	}

}
