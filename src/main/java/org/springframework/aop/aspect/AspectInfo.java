package org.springframework.aop.aspect;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.aop.PointcutLocator;

@AllArgsConstructor
@Getter
public class AspectInfo {
    private int orderIndex;
    private DefaultAspect aspectObject;
    private PointcutLocator pointcutLocator;
}
