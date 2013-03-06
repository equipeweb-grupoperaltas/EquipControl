package br.com.grupoperaltas.equipcontrol.infra;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @classname Public
 * @package   br.com.grupoperaltas.equipcontrol.utils
 *
 * @author Fabio Pratta <fabiobrotas@hotmail.com>
 * @data 02/01/2013
 * @version 1.0
 * 
 */

@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE, ElementType.METHOD })
public @interface Public { }
