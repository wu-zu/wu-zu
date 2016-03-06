package com.wuzu.web.ui.menu.domain;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QMenu is a Querydsl query type for Menu
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QMenu extends EntityPathBase<Menu> {

    private static final long serialVersionUID = 981657042L;

    public static final QMenu menu = new QMenu("menu");

    public final NumberPath<Integer> depth = createNumber("depth", Integer.class);

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final BooleanPath isOpened = createBoolean("isOpened");

    public final StringPath name = createString("name");

    public final NumberPath<Integer> orderInDepth = createNumber("orderInDepth", Integer.class);

    public final NumberPath<Integer> parentId = createNumber("parentId", Integer.class);

    public final StringPath type = createString("type");

    public final StringPath uri = createString("uri");

    public QMenu(String variable) {
        super(Menu.class, forVariable(variable));
    }

    public QMenu(Path<? extends Menu> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMenu(PathMetadata<?> metadata) {
        super(Menu.class, metadata);
    }

}

