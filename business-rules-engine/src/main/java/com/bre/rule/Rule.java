package com.bre.rule;

import com.bre.entities.Payment;

/**
 * Interface for rule defining the basic structure
 * 
 * @author ashish
 *
 */
public interface Rule {

	/**
	 * Conditions check, whether the Rule should be evaluated for hte provided
	 * {@link Payment}
	 * 
	 * @return true if Rule is to be applied for the provided Payment
	 */
	public boolean accepts(Payment payment);

	/**
	 * Executes the current rule on the provided {@link Payment}
	 * 
	 * @param payment
	 * 
	 */
	public void executeRuleOn(Payment payment);
}
